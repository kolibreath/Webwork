package edu.ccnu.online_article_publisher.kolibraeth.controller;

import edu.ccnu.online_article_publisher.kolibraeth.Constants;
import edu.ccnu.online_article_publisher.kolibraeth.dao.*;
import edu.ccnu.online_article_publisher.kolibraeth.model.UserSession;
import edu.ccnu.online_article_publisher.kolibraeth.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 处理用户相关的请求
 * 用户请求个人页面 详细信息 好友信息等
 */

@RestController
@RequestMapping("user")
public class UserController {
}
