package com.lab.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req2")
public class requestdemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        //获取虚拟目录（项目访问路径）
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //获取url（统一资源定位符）
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        //获取uri（统一资源标识符）
        String uri = req.getRequestURI();
        System.out.println(uri);
        //获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
        //获取请求头：浏览器版本信息
        String agent = req.getHeader("user-agent");
        System.out.println(agent);
        System.out.println("================================");
        Map<String, String[]> map = req.getParameterMap();
        for (String key :
                map.keySet()) {
            System.out.print(key+":");
            String[] values=map.get(key);
            for (String value :
                    values) {
                System.out.print(value+" ");

            }
            System.out.println();

        }
        System.out.println("================================");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby:
            hobbies) {
            System.out.println(hobby);
        }
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
//        BufferedReader br = req.getReader();
//        String Line = br.readLine();
//        System.out.println(Line);
    }
}
