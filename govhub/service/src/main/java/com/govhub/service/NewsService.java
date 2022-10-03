package com.govhub.service;

import com.govhub.domain.News;

import java.util.Date;
import java.util.List;

/**
 * @author Sin
 * @date 2022/8/23
 */
public interface NewsService {
    public List<News> getByDate(String city, Date time);


    public List<News> getByTimeQuantum(String city, Date startTime, Date endTime);


    public List<News> getAll(String city);


}
