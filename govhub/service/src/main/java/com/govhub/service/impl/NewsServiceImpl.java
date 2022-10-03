package com.govhub.service.impl;

import com.govhub.dao.NewsDao;
import com.govhub.domain.News;
import com.govhub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Sin
 * @date 2022/8/23
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> getByDate(String city, Date time) {
//        java.sql.Date date = new java.sql.Date(time.getTime());
//        List<News> result = newsDao.getByDate(city, date);
        List<News> result = newsDao.getByDate(city, time);

        return result;    }

    @Override
    public List<News> getByTimeQuantum(String city, Date startTime, Date endTime) {
        java.sql.Date startDate = new java.sql.Date(startTime.getTime());
        java.sql.Date endDate = new java.sql.Date(endTime.getTime());
        List<News> result = newsDao.getByTimeQuantum(city, startDate,endDate);

        return result;
    }

    @Override
    public List<News> getAll(String city) {
        List<News> result = newsDao.getAll(city);
        return result;
    }
}
