package com.govhub.service;

import com.govhub.domain.City;

import java.util.Date;
import java.util.List;

/**
 * @author Sin
 * @date 2022/7/29
 */
public interface CityService {

    /**
     * 根据url的城市名查询
     *
     * @param city
     * @param url
     * @return
     */
    public City getByUrl(String city, String url);

    /**
     * 根据城市名和时间查询
     *
     * @param city
     * @param time
     * @return
     */
    public List<City> getByDate(String city, Date time);

    /**
     * 查询一段时间内的数据
     * @param city
     * @param startTime
     * @param endTime
     * @return
     */
    public List<City> getByTimeQuantum(String city, Date startTime, Date endTime);

    /**
     * 根据城市名查询全部
     *
     * @param city
     * @return
     */
    public List<City> getAll(String city);

    /**
     * 根据城市名和url删除
     *
     * @param city
     * @param url
     * @return
     */
    public City delectByUrl(String city, String url);

    /**
     * 根据城市名和时间删除
     *
     * @param city
     * @param time
     * @return
     */
    public List<City> delectByDate(String city, Date time);

    /**
     * 根据城市名删除全部
     *
     * @param city
     * @return
     */
    public List<City> delectAll(String city);
}
