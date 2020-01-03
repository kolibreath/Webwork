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


        Article article = new Article(rick.getUserId(),group.getGroupId(),"2019.02.24 00:04:03"
                ,"Flutter 精解",
                "完善可以让 Flutter 可以运行在 Web 平台的 Hummingbird 项目；\n" +
                "继续尝试让 Flutter 运行在桌面级的平台之上（如 macOS 和 Windows）。\n" +
                "假如flutter支持web，windows，macOS，这简直无敌有没有....",
                "https://www.jianshu.com/p/0f5be015314d",386,3409);
        articleRepo.save(article);

        Article article2 = new Article(
                rick.getUserId(),group.getGroupId(),"2019.12.03 13:13:49","豆瓣9.2分，今年最牛逼的电影，没白等！",
                "最近这部电影很火，前几天公众号推荐过一次，但是后台仍一堆人求这部电影，今天再推荐一遍。\n,里面一些镜头让我一个大男人看的都热泪盈眶，很值得一看！",
                "https://www.jianshu.com/p/3adb756b2974",1818,37873 );
        articleRepo.save(article2);

        Article article3 = new Article(
                rick.getUserId(),group.getGroupId(),"2019.12.03 13:13:49","豆瓣9.2分，今年最牛逼的电影，没白等！",
                "最近这部电影很火，前几天公众号推荐过一次，但是后台仍一堆人求这部电影，今天再推荐一遍。\n,里面一些镜头让我一个大男人看的都热泪盈眶，很值得一看！",
                "https://www.jianshu.com/p/3adb756b2974",1992,6375 );
        articleRepo.save(article3);


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
