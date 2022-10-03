package com.govhub.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @author Sin
 * @date 2022/7/29
 */
public class City {
    private String url;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd ", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private  Date time;


    @Override
    public String toString() {
        return "City{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", time=" + time +
                '}';
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

}
