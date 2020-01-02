package edu.ccnu.online_article_publisher.kolibraeth.dao;

import javax.xml.ws.Response;

public class ResponseBean {

    private int code ;
    private String message;

    public ResponseBean(){}

    public ResponseBean(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
