package edu.ccnu.online_article_publisher.kolibraeth.test;


import edu.ccnu.online_article_publisher.kolibraeth.KolibraethApplication;
import edu.ccnu.online_article_publisher.kolibraeth.dao.Article;
import edu.ccnu.online_article_publisher.kolibraeth.dao.ArticleGroup;
import edu.ccnu.online_article_publisher.kolibraeth.dao.Banner;
import edu.ccnu.online_article_publisher.kolibraeth.dao.User;
import edu.ccnu.online_article_publisher.kolibraeth.repo.ArticleRepo;
import edu.ccnu.online_article_publisher.kolibraeth.repo.BannerRepo;
import edu.ccnu.online_article_publisher.kolibraeth.repo.GroupRepo;
import edu.ccnu.online_article_publisher.kolibraeth.repo.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KolibraethApplication.class)
public class Injection {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private ArticleRepo articleRepo;
    @Autowired
    private BannerRepo bannerRepo;


    @Test
    public void inject(){
        User  rick = new User(
                "rick@rick.com",
                "rick",
                "rickpass",
                 "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSx-GmdvA4AFYUn6vRJHGYcdIvCvsQuuNOxNDR6Rqr2O9USO4Gc&s");

        userRepo.save(rick);

        ArticleGroup group = new ArticleGroup("rick's favorite",rick.getUserId());
        groupRepo.save(group);


        Article article = new Article(
                rick.getUserId(),
                group.getGroupId(),
                System.currentTimeMillis(),
                "守望先锋",
                "我喜欢守望先锋");
        articleRepo.save(article);

        Article article2 = new Article(
                rick.getUserId(),
                group.getGroupId(),
                System.currentTimeMillis(),
                "炉石传说",
                "我喜欢炉石传说");
        articleRepo.save(article2);

        Banner banner1 = new Banner(
                "https://upload.jianshu.io/admin_banners/web_images/4860/8aec44af6460ad75f6bb56caa9ab501c0cfb2ba4.png?imageMogr2/auto-orient/strip"
                ,"https://www.jianshu.com/k/story2019_pc"
                ,System.currentTimeMillis(),
                "test"
        );
        Banner banner2 = new Banner(
                "https://upload.jianshu.io/admin_banners/web_images/4854/0eef040afc0ba407458fb900cee841df8d5274cb.png?imageMogr2/auto-orient/stripx"
                ,"https://www.jianshu.com/p/ad8dbbc313b7?utm_medium=index-banner&utm_source=desktop"
                ,System.currentTimeMillis(),
                "test"
        );
        bannerRepo.save(banner1);
        bannerRepo.save(banner2);

    }
}
