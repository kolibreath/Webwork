package edu.ccnu.online_article_publisher.kolibraeth.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {



    @RequestMapping("/1")
    public String turn2TestAjax(){
        return "test_request_yu";
    }

    @RequestMapping("/2")
    public String turn2TestRequest(){
        return "test_request";
    }

    @RequestMapping("/3")
    public String turn2newArticle(){
        return "Editor";
    }


}
