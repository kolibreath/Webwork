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
import javax.xml.transform.Result;
import java.util.Map;


/**
 * 发帖 删帖 回复帖子 等
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("post")
public class  ArticleController {

    @Autowired
    private ArticleRepo articleRepo;

    @RequestMapping(value = "/all")
    public ResultBean getAllArticle(){
        List<Article> articles = articleRepo.findAll();
        List<ArticleModel> articleModels = new LinkedList<>();
        for(Article article : articles) {
            ArticleModel articleModel = new ArticleModel(
                    article.getTitle(),
                    article.getContent(),
                    article.getLink(),
                    article.getWordCount(),
                    article.getTime(),
                    article.getViews()
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

        if(postContent == null || postTitle == null)
            return ResultBean.error(ResultBean.resources_not_found,"没有输入文章内容或者文章标题");

        //todo 时间
        Article post = new Article(userId,1,"2020-01-03",postTitle,postContent,"fucking shit",postContent.length(),0);
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

    @RequestMapping("/my_post")
    public ResultBean getMyPost(HttpSession httpSession){
        UserSession userSession= (UserSession) httpSession.getAttribute(Constants.USE_SESSION_KEY);
        int userId = userSession.getId();

        List<Article> articles = articleRepo.findByUserId(userId);

        List<ArticleModel> articleModels = new LinkedList<>();
        for(Article article : articles) {
            ArticleModel articleModel = new ArticleModel(
                    article.getTitle(),
                    article.getContent(),
                    article.getLink(),
                    article.getWordCount(),
                    article.getTime(),
                    article.getViews()
            );
            articleModels.add(articleModel);
        }
        return ResultBean.success(articleModels);

    }
}
