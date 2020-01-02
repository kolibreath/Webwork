package edu.ccnu.online_article_publisher.kolibraeth.controller;


import edu.ccnu.online_article_publisher.kolibraeth.Service.MailService;
import edu.ccnu.online_article_publisher.kolibraeth.dao.Email;
import edu.ccnu.online_article_publisher.kolibraeth.dao.ResponseBean;
import edu.ccnu.online_article_publisher.kolibraeth.dao.ResultBean;
import edu.ccnu.online_article_publisher.kolibraeth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController("mail")
public class MailSenderController {

    @Autowired
    private UserRepo repo;
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private MailService mailService;

    @RequestMapping("/checkCode")
    public ResultBean sendEmail(@RequestBody Email email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的验证码" + checkCode;
        ResultBean bean;
        try {
            mailService.sendSimpleMail(email.getEmailAddress(),"注册验证码",message);
            return ResultBean.success(new ResponseBean(ResultBean.success_code,"发送成功"));
        }catch (Exception e){
            return ResultBean.error(ResultBean.internal_error,"发送失败");
        }
    }

}
