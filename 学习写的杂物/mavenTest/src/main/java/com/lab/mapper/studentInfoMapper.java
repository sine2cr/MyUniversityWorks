package com.lab.mapper;

import com.lab.pojo.studentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.IdentityHashMap;
import java.util.List;

public interface studentInfoMapper {

    List<studentInfo> selectAll();

    List<studentInfo> selectName();

    List<studentInfo> selectNamebyId(int id);

    List<studentInfo> selectNamebyCondition(@Param("id") int id, @Param("Snamber") String Snamber);

    int insertStudentInfo(@Param("id") int id, @Param("Snamber") String Snamber, @Param("Sname") String Sname);

    int updateStudentInfo(@Param("id") int id, @Param("Snamber") String Snamber, @Param("Sname") String Sname);

    int dropStudentInfo(@Param("id") int id);

    int delById(@Param("id") int[] ids);
}
