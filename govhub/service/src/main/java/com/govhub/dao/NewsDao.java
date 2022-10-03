package com.govhub.dao;

import com.govhub.domain.City;
import com.govhub.domain.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Sin
 * @date 2022/8/23
 */
@Mapper
public interface NewsDao {
    public List<News> getAll(@Param("city") String city);

    public List<News> getByDate(@Param("city") String city, @Param("time") Date date);

    public List<News> getByTimeQuantum(@Param("city") String city, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

}
