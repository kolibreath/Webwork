package edu.ccnu.online_article_publisher.kolibraeth.dao;

public class ArticleModel{

    private String title;
    private String content;
    private String link;
    private int wordCount;
    private String time;
    private int views;


    public ArticleModel(String title, String content, String link, int wordCount, String time, int views) {
        this.title = title;
        this.content = content;
        this.link = link;
        this.wordCount = wordCount;
        this.time = time;
        this.views = views;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
