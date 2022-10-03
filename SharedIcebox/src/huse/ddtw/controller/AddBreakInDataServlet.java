package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.bookData;
import huse.ddtw.entity.borrowData;
import huse.ddtw.entity.breakinData;

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

@WebServlet(name = "AddBreakInDataServlet")
public class AddBreakInDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ifbreakin,flag,times;
        DataDao dao = new DataDao();
        breakinData breakinData = new breakinData();
        PrintWriter printWriter = response.getWriter();
        int result = 0;

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);



        ifbreakin = request.getParameter("ifbreakin");
        flag = request.getParameter("flag");

        breakinData = new breakinData(ifbreakin,flag,times);
        result = dao.addBreakinData(breakinData, request);

        //printWriter.print("!LF_flag:"+flag+"!");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ifbreakin,flag,times;
        DataDao dao = new DataDao();
        breakinData breakinData = new breakinData();
        PrintWriter printWriter = response.getWriter();
        int result = 0;

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);



        ifbreakin = request.getParameter("ifbreakin");
        flag = request.getParameter("flag");

        breakinData = new breakinData(ifbreakin,flag,times);
        result = dao.addBreakinData(breakinData, request);

     //   printWriter.print("!LF_flag:"+flag+"!");

    }
}
