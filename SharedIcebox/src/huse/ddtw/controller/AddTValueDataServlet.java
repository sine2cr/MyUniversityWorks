package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.t_condata;
import huse.ddtw.entity.t_valuedata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddTValueDataServlet")
public class AddTValueDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TinDH,TinDL,TG,LXD,TBegin,TEnd,time,times;


        DataDao dao = new DataDao();
        t_valuedata t_valuedata = null;

        int result = 0;
        PrintWriter out = response.getWriter();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        TinDH = request.getParameter("TinDH");
        TinDL = request.getParameter("TinDL");
        TG = request.getParameter("TG");
        LXD = request.getParameter("LXD");
        TBegin = request.getParameter("TBegin");
        TEnd = request.getParameter("TEnd");

        t_valuedata = new t_valuedata(TinDH, TinDL, TG, LXD,TBegin,TEnd,time, times);
        result = dao.addt_ValueData(t_valuedata, request);
//            con = new conData(fan1, fan2, motor, led, time, times);
//            result = dao.addConData(con, request);

        out.print("Status:"+result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String TinDH,TinDL,TG,LXD,TBegin,TEnd,time,times;


        DataDao dao = new DataDao();
        t_valuedata t_valuedata = null;

        int result = 0;
        PrintWriter out = response.getWriter();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        TinDH = request.getParameter("TinDH");
        TinDL = request.getParameter("TinDL");
        TG = request.getParameter("TG");
        LXD = request.getParameter("LXD");
        TBegin = request.getParameter("TBegin");
        TEnd = request.getParameter("TEnd");

        t_valuedata = new t_valuedata(TinDH, TinDL, TG, LXD,TBegin,TEnd,time, times);
        result = dao.addt_ValueData(t_valuedata, request);
//            con = new conData(fan1, fan2, motor, led, time, times);
//            result = dao.addConData(con, request);

        out.print("Status:"+result);
    }
}
