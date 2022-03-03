package com.example.management113a.mapper;

import com.example.management113a.pojo.StudentTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 小小萱
 * @version 1.0
 */
public interface StudentTimeMapper {

    List<StudentTime> selectTimeByNumber(@Param("startTime") String startTime, @Param("EndTime") String EndTime, @Param("snumber") String snumber);

    List<StudentTime> selectStartTimeByNumber( @Param("EndTime") String EndTime, @Param("snumber") String snumber);

    List<StudentTime> selectEndTimeBynumber(@Param("startTime") String startTime, @Param("snumber") String snumber);

    int insertStartTime(@Param("startTime") String startTime, @Param("snumber") String snumber);

    int insertEndTime(@Param("EndTime") String EndTime, @Param("snumber") String snumber);

    int insertTime(@Param("startTime") String startTime, @Param("EndTime") String EndTime, @Param("snumber") String snumber);

}
