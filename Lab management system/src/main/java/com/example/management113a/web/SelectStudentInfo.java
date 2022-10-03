package com.example.management113a.web;

import com.example.management113a.pojo.StudentInfo;
import com.example.management113a.service.StudentInfoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SelectStudentInfo", value = "/SelectStudentInfo")
public class SelectStudentInfo extends HttpServlet {
    StudentInfoService Service = new StudentInfoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String number = req.getParameter("number");
        List<StudentInfo> studentInfos = Service.selectStudentInfo(name, number);
        for (StudentInfo studentInfo:
             studentInfos) {
            req.getSession().setAttribute("snumber",number);
            req.getSession().setAttribute("sname",name);
            resp.sendRedirect("system.html");
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<script>alert(\"姓名或学号错误\")</script> ");
        writer.write("<a href=\"index.html\">返回首页</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
        this.doGet(req,resp);
    }
}
