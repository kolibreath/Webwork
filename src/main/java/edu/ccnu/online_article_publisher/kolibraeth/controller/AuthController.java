package edu.ccnu.online_article_publisher.kolibraeth.controller;

import edu.ccnu.online_article_publisher.kolibraeth.Constants;
import edu.ccnu.online_article_publisher.kolibraeth.dao.User;
import edu.ccnu.online_article_publisher.kolibraeth.model.UserSession;
import edu.ccnu.online_article_publisher.kolibraeth.repo.BannerRepo;
import edu.ccnu.online_article_publisher.kolibraeth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户注册登录
 * 用户修改密码
 */
@Controller
public class AuthController {

    //  @Autowired
    private UserRepo userRepo;
    @Autowired
    private BannerRepo bannerRepo;

    @Autowired
    public void setUserRepo (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/dologin")
    public String dologin(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");

        User user = userRepo.findByUserEmail(name);
        if (password.equals(user.getUserPassword())) {
            UserSession usrSession = new UserSession(user.getUserId(), user.getUserName(), user.getUserPassword());
            httpSession.setAttribute(Constants.USE_SESSION_KEY, usrSession);
            return "homePage";
        } else
            return "login";

    }

    @RequestMapping("/HomePage")
    public String HomePage1(){
        return "homePage";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/doregister")
    public String doregister(HttpServletRequest httpServletRequest,HttpSession httpSession)
    {
        String name=httpServletRequest.getParameter("name");
        String password=httpServletRequest.getParameter("password");
        String email=httpServletRequest.getParameter("email");

        //TODO
        if(userRepo.findAllByUserEmail(email)!=null){
            return "register";
        }
        else
        {
            User user=new User(name,password,email,Constants.DEFAULT_AVATAR);
            userRepo.save(user);
            return "login";
        }
    }

    //修改密码

    /**
     *
     * @param session
     * @param map
     * @return
     * 没有传新的用户密码 400
     * 出现异常500
     * 成功   200
     */
    @PostMapping("/password")
    @ResponseBody
    public int changePassword(HttpSession session ,@RequestBody Map<String,Object> map){
        UserSession user = (UserSession) session.getAttribute(Constants.USE_SESSION_KEY);
        String newPassword = (String) map.get("new_password");
        if(newPassword == null) return 400;
        int result = userRepo.updateUser(newPassword,user.getId());
        return 200;
    }

}

