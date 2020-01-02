package edu.ccnu.online_article_publisher.kolibraeth.dao;

import java.util.Collection;

public class ResultBean<T> {

    private T data;
    private int code ;
    private String message;

    public static int success_code = 200;
    public static int internal_error = 500;
    public static int resources_not_found = 400;

    public ResultBean(){

    }

    public ResultBean(T data, int code ){
        this.data = data;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    public static ResultBean error(int code , String message) {
        ResultBean bean = new ResultBean();
        bean.setCode(code);
        bean.setMessage(message);
        return bean;
    }

    public static <V> ResultBean success(V data){
        ResultBean bean = new ResultBean();
        bean.setCode(success_code);
        bean.setMessage("success");
        bean.setData(data);
        return bean;
    }


}
