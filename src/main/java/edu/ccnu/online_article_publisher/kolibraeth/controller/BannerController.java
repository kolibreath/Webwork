package edu.ccnu.online_article_publisher.kolibraeth.controller;


import edu.ccnu.online_article_publisher.kolibraeth.dao.Banner;
import edu.ccnu.online_article_publisher.kolibraeth.dao.ResultBean;
import edu.ccnu.online_article_publisher.kolibraeth.repo.BannerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("banner")
public class BannerController {

    @Autowired
    private BannerRepo bannerRepo;

    //Banner指的是所有的Banner 不做内容的分类
    @RequestMapping("/all")
    public ResultBean getBanners(){
        List<Banner> banner  = bannerRepo.findAll();
        return ResultBean.success(banner);
    }
}
