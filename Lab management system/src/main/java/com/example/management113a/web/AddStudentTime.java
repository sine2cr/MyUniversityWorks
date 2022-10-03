package com.example.management113a.web;

import com.example.management113a.pojo.StudentTime;
import com.example.management113a.service.StudentTimeService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddStudentTime", value = "/AddStudentTime")
public class AddStudentTime extends HttpServlet {
    StudentTimeService studentTimeService = new StudentTimeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String number = String.valueOf(req.getSession().getAttribute("snumber"));
        boolean isTrue = studentTimeService.addStudentTime(startTime, endTime, number);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println(isTrue == true ? "插入成功" : "插入失败");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
