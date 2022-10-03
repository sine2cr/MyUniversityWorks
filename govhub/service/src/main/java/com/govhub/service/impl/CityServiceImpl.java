package com.govhub.service.impl;

import com.govhub.dao.CityDaoBAk;
import com.govhub.domain.City;
import com.govhub.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Sin
 * @date 2022/7/29
 */
@Service
@Slf4j
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDaoBAk cityDao;

    @Override
    public City getByUrl(String city, String url) {
        City result = cityDao.getByUrl(city, url);
        return result;
    }

    @Override
    public List<City> getByDate(String city, Date time) {
        java.sql.Date date = new java.sql.Date(time.getTime());
        List<City> result = cityDao.getByDate(city, date);


        return result;
    }

    @Override
    public List<City> getByTimeQuantum(String city, Date startTime, Date endTime) {
//        java.sql.Date startDate = new java.sql.Date(startTime.getTime());
//        java.sql.Date endDate = new java.sql.Date(endTime.getTime());
//        List<City> result = cityDao.getByTimeQuantum(city, startDate, endDate);
        List<City> result = cityDao.getByTimeQuantum(city, startTime, endTime);

        return result;
    }

    @Override
    public List<City> getAll(String city) {

        List<City> result = cityDao.getAll(city);

        return result;
    }

    // TODO: 2022/7/29 删除功能暂时不实现
    @Override
    public City delectByUrl(String city, String url) {
        System.out.println("暂时不实现");
        return null;
    }

    @Override
    public List<City> delectByDate(String city, Date time) {
        System.out.println("暂时不实现");

        return null;
    }

    @Override
    public List<City> delectAll(String city) {
        System.out.println("暂时不实现");

        return null;
    }
}
