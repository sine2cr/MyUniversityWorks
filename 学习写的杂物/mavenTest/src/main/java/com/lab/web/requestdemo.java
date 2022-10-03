package com.lab.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class requestdemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方式
        String method=req.getMethod();
        System.out.println(method);
        //获取虚拟目录（项目访问路径）
        String contextPath= req.getContextPath();
        System.out.println(contextPath);
        //获取url（统一资源定位符）
        StringBuffer url=req.getRequestURL();
        System.out.println(url.toString());
        //获取uri（统一资源标识符）
        String uri =req.getRequestURI();
        System.out.println(uri);
        //获取请求参数
        String queryString=req.getQueryString();
        System.out.println(queryString);
        //获取请求头：浏览器版本信息
        String agent=req.getHeader("user-agent");
        System.out.println(agent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = req.getReader();
        String Line =br.readLine();
        System.out.println(Line);
    }
}
