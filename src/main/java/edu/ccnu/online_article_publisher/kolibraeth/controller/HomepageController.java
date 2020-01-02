package edu.ccnu.online_article_publisher.kolibraeth.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/***
 * 管理整个主页面的逻辑请求
 */
//todo restcontroller
@Controller
@RequestMapping("homepage")
public class HomepageController {
    @RequestMapping("/my")
    public String record(){
        return "my";
    }
    @RequestMapping("/work")
    public String clas(){
        return "work";
    }
    @RequestMapping("/classification")
    public String my(){
        return "classification";
    }
    @RequestMapping("/back")
    public String back(){return "homepage";}



}
