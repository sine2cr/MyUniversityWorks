package com.govhub.dao;

import com.govhub.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CityDaoBAk {


    //  @Select("select * from #{city} where url  = #{url}")

    public City getByUrl(@Param("city") String city, @Param("url") String url);

    //  @Select("select * from #{city} where time = #{time}")

    public List<City> getByDate(@Param("city") String city, @Param("time") Date time);

    public List<City> getByTimeQuantum(@Param("city") String city, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
    //  @Select("select * from #{city}")

    public List<City> getAll(@Param("city") String city);

    // @Delete("delete  from #{city} where url  = #{url}")

    public City delectByUrl(@Param("city") String city, @Param("url") String url);

    //  @Delete("delete  from #{city} where time = #{time}")

    public List<City> delectByDate(@Param("city") String city, @Param("time") Date time);

    //   @Delete("delete  from #{city}")

    public List<City> delectAll(String city);

}
