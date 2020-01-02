package edu.ccnu.online_article_publisher.kolibraeth.dao;

public class Email {
    String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
