package com.example.management113a.service;

import com.example.management113a.mapper.StudentInfoMapper;
import com.example.management113a.mapper.StudentTimeMapper;
import com.example.management113a.pojo.StudentTime;
import com.example.management113a.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author beicen
 * @version 1.0
 */
public class StudentTimeService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public boolean addStudentTime( String startTime,String EndTime,String snumber){
        SqlSession sqlSession = factory.openSession();
        StudentTimeMapper mapper = sqlSession.getMapper(StudentTimeMapper.class);
        if (startTime!=null&&EndTime!=null&&snumber!=null){
            int i = mapper.insertTime(startTime,EndTime,snumber);
            sqlSession.commit();
            sqlSession.close();
            return i>0;
        }else if (startTime==null&&EndTime!=null&&snumber!=null){
            int i = mapper.insertEndTime(EndTime, snumber);
            sqlSession.commit();
            sqlSession.close();
            return i>0;
        }else if (startTime!=null&&EndTime==null&&snumber!=null){
            int i = mapper.insertStartTime(startTime, snumber);
            sqlSession.commit();
            sqlSession.close();
            return i>0;
        }else if (snumber==null){
            sqlSession.close();
            return false;
        }else {
            sqlSession.close();
            return false;
        }
    }
    public List<StudentTime>selecAll(String startTime,String EndTime,String snumber){
       SqlSession sqlSession = factory.openSession();
       StudentTimeMapper mapper = sqlSession.getMapper(StudentTimeMapper.class);
       List<StudentTime> studentTimes = mapper.selectTimeByNumber(startTime,EndTime,snumber);
       sqlSession.close();
       return studentTimes;
   }
    public List<StudentTime>selectStartTime(String EndTime,String snumber){
       SqlSession sqlSession = factory.openSession();
       StudentTimeMapper mapper = sqlSession.getMapper(StudentTimeMapper.class);
       List<StudentTime> studentTimes = mapper.selectStartTimeByNumber(EndTime,snumber);
       sqlSession.close();
       return studentTimes;
   }
    public List<StudentTime>selectEndtime(String startTime,String snumber){
       SqlSession sqlSession = factory.openSession();
       StudentTimeMapper mapper = sqlSession.getMapper(StudentTimeMapper.class);
       List<StudentTime> studentTimes = mapper.selectEndTimeBynumber(startTime,snumber);
       sqlSession.close();
       return studentTimes;
   }
}
