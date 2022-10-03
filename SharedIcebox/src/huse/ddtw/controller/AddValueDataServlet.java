package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.valueData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddValueDataServlet")
public class AddValueDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String value1,value2,value3,time,times,flag;
        DataDao dao = new DataDao();
        valueData valueData = null;
        int result = 0;
        PrintWriter printWriter = response.getWriter();
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        value1 = request.getParameter("value1");
        value2 = request.getParameter("value2");
        value3 = request.getParameter("value3");
        flag = request.getParameter("flag");

        valueData = dao.findNearValueData(request).get(0);


        valueData = new valueData(value1, value2, value3,flag,time,times);
        result = dao.addValueData(valueData, request);

        printWriter.print("Status:"+result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String value1,value2,value3,time,times,flag;
        DataDao dao = new DataDao();
        valueData valueData = null;
        int result = 0;
        PrintWriter printWriter = response.getWriter();
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        value1 = request.getParameter("value1");
        value2 = request.getParameter("value2");
        value3 = request.getParameter("value3");
        flag = request.getParameter("flag");

        valueData = dao.findNearValueData(request).get(0);

        valueData = new valueData(value1, value2, value3,flag,time,times);
        result = dao.addValueData(valueData, request);

        printWriter.print("Status:"+result);
    }
}
