package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.conData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddConDataServlet")
public class AddConDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fan1,fan2,motor,led,time,times,flag,fan1_pwm,fan2_pwm,led_pwm;


        DataDao dao = new DataDao();
        conData con = null;

        int result = 0;
        PrintWriter out = response.getWriter();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        fan1 = request.getParameter("fan1");
        fan2 = request.getParameter("fan2");
        motor = request.getParameter("motor");
        led = request.getParameter("led");
        flag = request.getParameter("flag");
        fan1_pwm = request.getParameter("fan1_pwm");
        fan2_pwm = request.getParameter("fan2_pwm");
        led_pwm = request.getParameter("led_pwm");

        if(Integer.parseInt(flag) == 0)
        {
            con = new conData(fan1, fan2, motor, led, time, times, fan1_pwm, fan2_pwm, led_pwm);
            result = dao.addCon_pwmData(con, request);
//            con = new conData(fan1, fan2, motor, led, time, times);
//            result = dao.addConData(con, request);

        }
        out.print("Status:"+result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fan1,fan2,motor,led,time,times,flag,fan1_pwm,fan2_pwm,led_pwm;


        DataDao dao = new DataDao();
        conData con = null;

        int result = 0;
        PrintWriter out = response.getWriter();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);

        fan1 = request.getParameter("fan1");
        fan2 = request.getParameter("fan2");
        motor = request.getParameter("motor");
        led = request.getParameter("led");
        flag = request.getParameter("flag");
        fan1_pwm = request.getParameter("fan1_pwm");
        fan2_pwm = request.getParameter("fan2_pwm");
        led_pwm = request.getParameter("led_pwm");

        if(Integer.parseInt(flag) == 0)
        {
            con = new conData(fan1, fan2, motor, led, time, times, fan1_pwm, fan2_pwm, led_pwm);
            result = dao.addCon_pwmData(con, request);
//            con = new conData(fan1, fan2, motor, led, time, times);
//            result = dao.addConData(con, request);
        }
        out.print("Status:"+result);

    }
}
