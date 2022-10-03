package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.conData;
import huse.ddtw.entity.t_condata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddTConDataServlet")
public class AddTConDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bright,SpeedM1,SpeedM2,time,times;


        DataDao dao = new DataDao();
        t_condata t_condata = null;

        int result = 0;
        PrintWriter out = response.getWriter();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        Bright = request.getParameter("Bright");
        SpeedM1 = request.getParameter("SpeedM1");
        SpeedM2 = request.getParameter("SpeedM2");

        t_condata = new t_condata(Bright, SpeedM1, SpeedM2, time, times);
        result = dao.addt_ConData(t_condata, request);
//            con = new conData(fan1, fan2, motor, led, time, times);
//            result = dao.addConData(con, request);

        out.print("Status:"+result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bright,SpeedM1,SpeedM2,time,times;


        DataDao dao = new DataDao();
        t_condata t_condata = null;

        int result = 0;
        PrintWriter out = response.getWriter();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        Bright = request.getParameter("Bright");
        SpeedM1 = request.getParameter("SpeedM1");
        SpeedM2 = request.getParameter("SpeedM2");

            t_condata = new t_condata(Bright, SpeedM1, SpeedM2, time, times);
            result = dao.addt_ConData(t_condata, request);
//            con = new conData(fan1, fan2, motor, led, time, times);
//            result = dao.addConData(con, request);

        out.print("Status:"+result);
    }


}
