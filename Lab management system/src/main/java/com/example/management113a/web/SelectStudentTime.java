package com.example.management113a.web;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONArray;

import com.example.management113a.pojo.Excel;
import com.example.management113a.pojo.StudentTime;
import com.example.management113a.service.StudentTimeService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectStudentTime", value = "/SelectStudentTime")
public class SelectStudentTime extends HttpServlet {
    StudentTimeService studentTimeService = new StudentTimeService();

    //public static List<StudentTime> Bug;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String number = String.valueOf(req.getSession().getAttribute("snumber"));
        if (startTime != null && endTime == null && number != null) {
            List<StudentTime> studentTimes = studentTimeService.selecAll(startTime, endTime, number);
            resp.setContentType("application/x-download");
            resp.setCharacterEncoding("utf8");

            resp.setHeader("Content-Disposition", "attachment;filename=123.xlsx");
            File file = new File("学生考勤时间表.xlsx");
            if (studentTimes.size() != 0) {
                ArrayList<Excel> objects = new ArrayList<>();
                for (StudentTime s :
                        studentTimes) {
                    Excel excel = new Excel();
                    excel.setStartTime(s.getStartTime());
                    excel.setEndTime(s.getEndTime());
                    excel.setStudentNumber(number);
                    excel.setStudentName(String.valueOf(req.getSession().getAttribute("sname")));
                    objects.add(excel);
                }
                EasyExcel.write(file, Excel.class).sheet("数据").doWrite(objects);
//                Bug=studentTimes;
                req.getSession().setAttribute("studentTimes", studentTimes);

                FileInputStream fileInputStream = new FileInputStream(file);
                ServletOutputStream out = resp.getOutputStream();
                int i;
                while ((i=fileInputStream.read())!=-1){
                    out.write(i);
                }
            }


        } else if (startTime == null && endTime != null && number != null) {
            List<StudentTime> studentTimes = studentTimeService.selecAll(startTime, endTime, number);
            resp.setContentType("application/x-download");
            resp.setCharacterEncoding("utf8");

            resp.setHeader("Content-Disposition", "attachment;filename=123.xlsx");
            File file = new File("学生考勤时间表.xlsx");
            if (studentTimes.size() != 0) {
                ArrayList<Excel> objects = new ArrayList<>();
                for (StudentTime s :
                        studentTimes) {
                    Excel excel = new Excel();
                    excel.setStartTime(s.getStartTime());
                    excel.setEndTime(s.getEndTime());
                    excel.setStudentNumber(number);
                    excel.setStudentName(String.valueOf(req.getSession().getAttribute("sname")));
                    objects.add(excel);
                }
                EasyExcel.write(file, Excel.class).sheet("数据").doWrite(objects);
//                Bug=studentTimes;
                req.getSession().setAttribute("studentTimes", studentTimes);

                FileInputStream fileInputStream = new FileInputStream(file);
                ServletOutputStream out = resp.getOutputStream();
                int i;
                while ((i=fileInputStream.read())!=-1){
                    out.write(i);
                }
            }



        } else if (startTime != null && endTime != null && number != null) {
            List<StudentTime> studentTimes = studentTimeService.selecAll(startTime, endTime, number);
            resp.setContentType("application/x-download");
            resp.setCharacterEncoding("utf8");

            resp.setHeader("Content-Disposition", "attachment;filename=123.xlsx");
            File file = new File("学生考勤时间表.xlsx");
            if (studentTimes.size() != 0) {
                ArrayList<Excel> objects = new ArrayList<>();
                for (StudentTime s :
                        studentTimes) {
                    Excel excel = new Excel();
                    excel.setStartTime(s.getStartTime());
                    excel.setEndTime(s.getEndTime());
                    excel.setStudentNumber(number);
                    excel.setStudentName(String.valueOf(req.getSession().getAttribute("sname")));
                    objects.add(excel);
                }
                EasyExcel.write(file, Excel.class).sheet("数据").doWrite(objects);
//                Bug=studentTimes;
                req.getSession().setAttribute("studentTimes", studentTimes);

                FileInputStream fileInputStream = new FileInputStream(file);
                ServletOutputStream out = resp.getOutputStream();
              int i;
                while ((i=fileInputStream.read())!=-1){
                    out.write(i);
                }
            }



        } else {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.write("<script>alert(\"时间错误，请重新输入\")</script> ");
            writer.write("<a href=\"system2.html\">返回查询页面</a>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
