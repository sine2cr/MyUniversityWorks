package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.breakinData;
import huse.ddtw.entity.smokeData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddSmokeDataServlet")
public class AddSmokeDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String smoke1,smoke2,time,times;
        String ifbreakin,flag;
        DataDao dao = new DataDao();
        breakinData breakinData = new breakinData();
        smokeData smokeData = new smokeData();
        PrintWriter printWriter = response.getWriter();
        int result = 0;

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        smoke1 = request.getParameter("smoke1");
        smoke2 = request.getParameter("smoke2");

        smokeData = new smokeData(smoke1,smoke2,time,times);
        result = dao.addSomkeData(smokeData, request);

        ifbreakin = request.getParameter("ifbreakin");
        flag = dao.findSmokeBreakData(request).get(0).getFlag();
        if(flag.equals("1"))
        {
            ifbreakin = "0";
        }

        breakinData = new breakinData(ifbreakin,flag,times);
        result = dao.addBreakinData(breakinData, request);

        printWriter.print("!LF_flag:"+flag+",!");

        //   printWriter.print("Status:"+result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String smoke1,smoke2,time,times;
        String ifbreakin,flag;
        DataDao dao = new DataDao();
        breakinData breakinData = new breakinData();
        smokeData smokeData = new smokeData();
        PrintWriter printWriter = response.getWriter();
        int result = 0;

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        smoke1 = request.getParameter("smoke1");
        smoke2 = request.getParameter("smoke2");

        smokeData = new smokeData(smoke1,smoke2,time,times);
        result = dao.addSomkeData(smokeData, request);

        ifbreakin = request.getParameter("ifbreakin");
        flag = dao.findSmokeBreakData(request).get(0).getFlag();
        if(flag.equals("1"))
        {
            ifbreakin = "0";
        }

        breakinData = new breakinData(ifbreakin,flag,times);
        result = dao.addBreakinData(breakinData, request);

        printWriter.print("!LF_flag:"+flag+",!");

        //   printWriter.print("Status:"+result);
    }
}
