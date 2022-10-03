package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.bookData;
import huse.ddtw.entity.borrowData;
import huse.ddtw.entity.boxdata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@WebServlet(name = "AddVIDServlet")
public class AddVIDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String VID,PID,time,times;
        DataDao dao = new DataDao();
        boxdata boxdata = new boxdata();
        PrintWriter printWriter = response.getWriter();
        int result = 0;

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);


        VID = "202123";
        PID = request.getParameter("PID");



        boxdata = new boxdata(VID,PID,times,time);

        result = dao.addBoxData(boxdata, request);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String VID,PID,time,times;
        DataDao dao = new DataDao();
        boxdata boxdata = new boxdata();
        PrintWriter printWriter = response.getWriter();
        int result = 0;

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);


        VID = "202123";
        PID = request.getParameter("PID");



        boxdata = new boxdata(VID,PID,times,time);

        result = dao.addBoxData(boxdata, request);


    }
}
