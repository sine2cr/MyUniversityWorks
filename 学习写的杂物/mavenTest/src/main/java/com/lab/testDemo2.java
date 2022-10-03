package com.lab;

import com.lab.mapper.studentInfoMapper;
import com.lab.pojo.studentInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/*
 *mybalit代理开发
 *
 */
public class testDemo2 {
    public static void main(String[] args) throws Exception {
        //加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行sql语句
        //List<studentInfo> studentInfos= sqlSession.selectList("test.selectAll");
        //执行sql代理方法
        //获取代理对象
        studentInfoMapper studentInfosMapper = sqlSession.getMapper(studentInfoMapper.class);
        List<studentInfo> studentInfos = studentInfosMapper.selectAll();
        List<studentInfo> studentName = studentInfosMapper.selectName();
        List<studentInfo> studentName2 = studentInfosMapper.selectNamebyId(1);
        List<studentInfo> studentName3 = studentInfosMapper.selectNamebyCondition(1," 202006040238");
//        int a=studentInfosMapper.insertStudentInfo(8,"202006040240","郑萱3");
   //     System.out.println(a);
    //   studentInfosMapper.updateStudentInfo(8,"202006040245","郑萱5");
     //   studentInfosMapper.dropStudentInfo(8);
     //   int[]a={5,6,7};
     //   studentInfosMapper.delById(a);

        System.out.println(studentInfos);
        System.out.println(studentName);
        System.out.println(studentName2);
        System.out.println(studentName3);
        sqlSession.close();
    }
}
