package edu.ccnu.online_article_publisher.kolibraeth.controller;


import java.util.LinkedList;
import java.util.List;
import edu.ccnu.online_article_publisher.kolibraeth.Constants;
import edu.ccnu.online_article_publisher.kolibraeth.dao.Article;
import edu.ccnu.online_article_publisher.kolibraeth.dao.ArticleModel;
import edu.ccnu.online_article_publisher.kolibraeth.dao.ResultBean;
import edu.ccnu.online_article_publisher.kolibraeth.dao.User;
import edu.ccnu.online_article_publisher.kolibraeth.model.UserSession;
import edu.ccnu.online_article_publisher.kolibraeth.repo.ArticleRepo;
import edu.ccnu.online_article_publisher.kolibraeth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * 发帖 删帖 回复帖子 等
 */
@RestController
@RequestMapping("post")
public class  ArticleController {

    @Autowired
    private ArticleRepo articleRepo;
    @Autowired
    private UserRepo userRepo;


    @RequestMapping(value = "/all")
    public ResultBean getAllArticle(){
        List<Article> articles = articleRepo.findAll();


        List<ArticleModel> articleModels = new LinkedList<>();
        for(Article article : articles) {
            int userId = article.getUserId();
            User user = userRepo.findUserByUserId(userId);
            String userName = user.getUserName();
            int subStringLenghth = article.getContent().length()> 20 ? 20: article.getContent().length();
            ArticleModel articleModel = new ArticleModel(
                    article.getTitle()
                    , article.getContent().substring(0, subStringLenghth),
                    userName,
                    user.getUserAvatar(),
                    article.getPostId()
            );
            articleModels.add(articleModel);
        }
        return ResultBean.success(articleModels);
    }

    @PostMapping(value = "/new_post")
    //成功 200 错误 返回 500
    //从当前的userSession中取出
    public ResultBean newPost(HttpSession session, @RequestBody Map<String,Object> map){
        UserSession user  = (UserSession) session.getAttribute(Constants.USE_SESSION_KEY);
        int userId = user.getId();

        //获取的内容
        //todo test!
        String postContent = (String) map.get("postContent");
        String postTitle = (String) map.get("postTitle");
        int  groupId;
        long time ;

        try {
            groupId = (int) map.get("groupId");
            time = (long) map.get("time");
        }catch (Exception e){
            return ResultBean.error(ResultBean.internal_error,"解析异常！");
        }
        if(postContent == null || postTitle == null)
            return ResultBean.error(ResultBean.resources_not_found,"没有输入文章内容或者文章标题");
        Article post = new Article(userId,groupId,time,postTitle,postContent);
        articleRepo.save(post);
        return ResultBean.success(post);
    }


    //todo test here!
    @PostMapping("/delete_post")
    public int deletePost(@RequestBody Map<String,Object> map)
    {
        int postId;
        try {
            postId = Integer.parseInt((String) map.get("postId"));
        }catch (Exception e){
            return 500;
        }
       articleRepo.deleteById(postId);
        return 200;
    }
}
