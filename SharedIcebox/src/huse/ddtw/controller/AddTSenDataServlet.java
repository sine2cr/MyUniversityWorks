package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddTSenDataServlet")
public class AddTSenDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Tin,Tout,LXin,VStatus,time,times;

        DataDao dao = new DataDao();
        t_sendata t_sendata = null;
        t_condata t_condata = null;
        t_valuedata t_valuedata = null;


        int result = 0;
        PrintWriter out = response.getWriter();
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);



        Tin = request.getParameter("Tin");
        Tout = request.getParameter("Tout");
        LXin = request.getParameter("LXin");
        VStatus = request.getParameter("VStatus");




        t_sendata = new t_sendata(Tin, Tout, LXin,VStatus, time,times);
        result = dao.addt_sendata(t_sendata, request);

        t_condata = dao.findNeart_condata(request).get(0);
        t_valuedata = dao.findNeart_valuedata(request).get(0);



        out.print("!led:"+(t_condata.getBright().length()>0?1:0)+",fan2:"+(t_condata.getSpeedM1().length()>0?1:0)+",fan1:"+(t_condata.getSPeedM2().length()>0?1:0)+",value1:"+t_valuedata.getTinDH()+",value2:"+t_valuedata.getTinDL()+",TG:"+t_valuedata.getTG()+",value3:"+t_valuedata.getLXD()+",TBegin:"+t_valuedata.getTBegin()+",TEnd:"+t_valuedata.getTEnd()+",!");

//        out.print("!fan1:"+con.getFan1()+",fan2:"+con.getFan2()+",motor:"+con.getMotor()+",led:"+con.getLed()+",fan1_pwm:"+con.getFan1_pwm()+",fan2_pwm:"+con.getFan2_pwm()+",value1:"+valueData.getValue1()+",value2:"+valueData.getValue2()+",value3:"+valueData.getValue3()+",flag:"+valueData.getFlag()+",!");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Tin,Tout,LXin,VStatus,time,times;

        DataDao dao = new DataDao();
        t_sendata t_sendata = null;
        t_condata t_condata = null;
        t_valuedata t_valuedata = null;


        int result = 0;
        PrintWriter out = response.getWriter();
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);



        Tin = request.getParameter("Tin");
        Tout = request.getParameter("Tout");
        LXin = request.getParameter("LXin");
        VStatus = request.getParameter("VStatus");




        t_sendata = new t_sendata(Tin, Tout, LXin,VStatus, time,times);
        result = dao.addt_sendata(t_sendata, request);

        t_condata = dao.findNeart_condata(request).get(0);
        t_valuedata = dao.findNeart_valuedata(request).get(0);



        out.print("!led_pwm:"+t_condata.getBright()+",fan2_pwm:"+t_condata.getSpeedM1()+",fan1_pwm:"+t_condata.getSPeedM2()+",value1:"+t_valuedata.getTinDH()+",value2:"+t_valuedata.getTinDL()+",TG:"+t_valuedata.getTG()+",value3:"+t_valuedata.getLXD()+",TBegin:"+t_valuedata.getTBegin()+",TEnd:"+t_valuedata.getTEnd()+",!");

//        out.print("!fan1:"+con.getFan1()+",fan2:"+con.getFan2()+",motor:"+con.getMotor()+",led:"+con.getLed()+",fan1_pwm:"+con.getFan1_pwm()+",fan2_pwm:"+con.getFan2_pwm()+",value1:"+valueData.getValue1()+",value2:"+valueData.getValue2()+",value3:"+valueData.getValue3()+",flag:"+valueData.getFlag()+",!");

    }
}
