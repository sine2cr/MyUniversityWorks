package com.lab;

import com.lab.mapper.studentInfoMapper;
import com.lab.pojo.studentInfo;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class testDemo2Test extends TestCase {
    @Test
    public void testMain() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象来执行sql语句
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行sql语句
        //List<studentInfo> studentInfos= sqlSession.selectList("test.selectAll");
        //执行sql代理方法
        //获取代理对象
        studentInfoMapper studentInfosMapper=sqlSession.getMapper(studentInfoMapper.class);
        List<studentInfo> studentInfos= studentInfosMapper.selectAll();
        System.out.println(studentInfos);
        sqlSession.close();
        // TODO: 2021/11/28  这里缺少一个注释
    }
}