package com.lab;

import com.lab.pojo.studentInfo;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testDemo {
    public static void main(String[] args) throws Exception {
        //加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        List<studentInfo> studentInfos = sqlSession.selectList("test.selectAll");
        System.out.println(studentInfos);
        sqlSession.close();
    }
}

