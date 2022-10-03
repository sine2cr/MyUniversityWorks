package com.govhub.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Sin
 * @date 2022/8/23
 */
public class News {
    private String url;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd ", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private Date time;

    public News(String url, String title, Date time) {
        this.url = url;
        this.title = title;
        this.time = time;
    }

    public News() {
    }

    @Override
    public String toString() {
        return "News{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", time=" + time +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
