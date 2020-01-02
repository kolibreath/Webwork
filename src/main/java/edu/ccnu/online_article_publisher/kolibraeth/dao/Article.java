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
    private Long time;

    @Column
    private String title;

    @Column
    private String content;

    public Article(){
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Article(int userId, int groupId, long time, String title, String content) {
        this.userId = userId;
        this.groupId = groupId;
        this.time = time;
        this.title = title;
        this.content = content;
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
