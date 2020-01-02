package edu.ccnu.online_article_publisher.kolibraeth.dao;

public class ArticleModel{

    private String title;
    private String content;
    private String userName;
    private String userAvatar;
    private int articleId;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public ArticleModel(String title, String content, String userName, String userAvatar, int articleId) {
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.articleId = articleId;
    }
}
