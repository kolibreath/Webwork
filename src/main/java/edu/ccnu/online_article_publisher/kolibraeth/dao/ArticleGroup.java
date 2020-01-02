package edu.ccnu.online_article_publisher.kolibraeth.dao;


import javax.persistence.*;

@Entity
@Table(name = "article_group")
public class ArticleGroup {

    @Id
    @GeneratedValue
    private int groupId;

    @Column
    private String groupName;

    @Column
    private int articleId;


    public ArticleGroup(String groupName, int articleId) {
        this.groupName = groupName;
        this.articleId = articleId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}

