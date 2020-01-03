package edu.ccnu.online_article_publisher.kolibraeth.dao;


import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    private int postId;

    @Column
    private int userId;

    @Column
    private int groupId;

    @Column
    private String time;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String link;

    @Column
    private int wordCount;

    @Column
    private int views;


    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Article(){
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Article(int userId, int groupId, String time, String title, String content, String link, int wordCount, int views) {
        this.userId = userId;
        this.groupId = groupId;
        this.time = time;
        this.title = title;
        this.content = content;
        this.link = link;
        this.wordCount = wordCount;
        this.views = views;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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
}
