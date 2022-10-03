package com.example.management113a.web;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.management113a.pojo.Excel;
import com.example.management113a.pojo.StudentTime;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

//import static com.example.management113a.web.SelectStudentTime.Bug;


@WebServlet(name = "ExcelDownload", value = "/ExcelDownload")
public class ExcelDownload extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        new  Excel().setStudentNumber(String.valueOf(req.getSession().getAttribute("snumber")));
//
//        List<StudentTime> studentTimes = (List<StudentTime>)req.getSession().getAttribute("studentTimes");
//        List<StudentTime> BUg;
//        FileOutputStream fileOutputStream = new FileOutputStream("学生考勤时间表.xlsx");
//        ArrayList<Excel> objects = new ArrayList<>();
//        Excel excel = new Excel();
//        for (StudentTime Bug :
//                Bug) {
//            StudentTime o = new StudentTime();
//            excel.setStartTime(o.getStartTime());
//            excel.setEndTime(o.getEndTime());
//            System.out.println(excel.toString());
//            objects.add(excel);
//            System.out.println(objects.toString());
//        }
//      EasyExcel.write(fileOutputStream,Excel.class).sheet("数据").doWrite(objects);
//
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
