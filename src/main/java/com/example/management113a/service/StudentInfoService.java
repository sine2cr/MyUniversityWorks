package com.example.management113a.service;

import com.example.management113a.mapper.StudentInfoMapper;
import com.example.management113a.pojo.StudentInfo;
import com.example.management113a.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author beicen
 * @version 1.0
 */
public class StudentInfoService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public boolean addStudentInfo(String Sname, String snumber) {
        SqlSession sqlSession = factory.openSession();
        StudentInfoMapper mapper = sqlSession.getMapper(StudentInfoMapper.class);
        int i = mapper.insertAll(Sname, snumber);
        sqlSession.commit();
        sqlSession.close();
        return i > 0;
    }

    public boolean deleteStudentInfo(String sname, String snumber) {
        SqlSession sqlSession = factory.openSession();
        StudentInfoMapper mapper = sqlSession.getMapper(StudentInfoMapper.class);
        int i = mapper.deleteByName(sname, snumber);
        sqlSession.commit();
        sqlSession.close();
        return i > 0;
    }

    public boolean updateStudentInfo(String sname, String snumber) {
        SqlSession sqlSession = factory.openSession();
        StudentInfoMapper mapper = sqlSession.getMapper(StudentInfoMapper.class);
        if (sname == null && snumber != null) {
            int i = mapper.updeteByNumber(sname, snumber);
            sqlSession.commit();
            sqlSession.close();
            return i > 0;
        } else if (snumber == null && sname != null) {
            int i = mapper.updeteByName(sname, snumber);
            sqlSession.commit();
            sqlSession.close();
            return i > 0;
        } else if (snumber == null && sname == null){
            sqlSession.close();
            return false;
        } else {
            int i = mapper.updeteByNumber(sname, snumber);
            sqlSession.commit();
            sqlSession.close();
            return i > 0;
        }
    }

    public List<StudentInfo> selectStudentInfo(String sname, String snumber) {
        SqlSession sqlSession = factory.openSession();
        StudentInfoMapper mapper = sqlSession.getMapper(StudentInfoMapper.class);
        if (snumber == null && sname != null) {
            List<StudentInfo> studentInfos = mapper.selectByName(sname);
            sqlSession.close();
            return studentInfos;
        } else if (sname == null && snumber != null) {
            List<StudentInfo> studentInfos = mapper.selectByNumber(snumber);
            sqlSession.close();
            return studentInfos;
        } else if (sname != null && snumber != null){
            List<StudentInfo> studentInfos = mapper.selectByNumber(snumber);
            sqlSession.close();
            return studentInfos;
        }else {
            List<StudentInfo> studentInfos = mapper.selectByNumber(snumber);
            sqlSession.close();
            return studentInfos;
        }
    }
}
