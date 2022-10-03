package com.example.management113a.mapper;

import com.example.management113a.pojo.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sin
 * @version 1.0
 */
public interface StudentInfoMapper {
    List<StudentInfo> selectByName(String sname);

    List<StudentInfo> selectByNumber(String snumber);

    int updeteByName(@Param("sname") String sname, @Param("snumber") String snumber);

    int updeteByNumber(@Param("sname") String sname, @Param("snumber") String snumber);

    int insertAll(@Param("sname") String sname, @Param("snumber") String snumber);

    int deleteByName(@Param("sname") String sname, @Param("snumber") String snumber);

    int deleteBynumber(@Param("sname") String sname, @Param("snumber") String snumber);
}
