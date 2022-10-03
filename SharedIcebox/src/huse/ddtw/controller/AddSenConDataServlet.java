package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.conData;
import huse.ddtw.entity.senData;
import huse.ddtw.entity.valueData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AddSenConDataServlet")
public class AddSenConDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tem,hum,light,fan1,fan2,motor,led,time,times,value1,value2,value3,flag,fan1_pwm,fan2_pwm,led_pwm;


        DataDao dao = new DataDao();
        senData sen = null;
        conData con = null;
        valueData valueData = null;


        int result = 0;
        PrintWriter out = response.getWriter();
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);



        tem = request.getParameter("tem");
        hum = request.getParameter("hum");
        light = request.getParameter("light");
        fan1 = request.getParameter("fan1");
        fan2 = request.getParameter("fan2");
        motor = request.getParameter("motor");
        led = request.getParameter("led");
        flag = request.getParameter("flag");
        fan1_pwm = request.getParameter("fan1_pwm");
        fan2_pwm = request.getParameter("fan2_pwm");
        led_pwm = request.getParameter("led_pwm");

        valueData = dao.findNearValueData(request).get(0);
//        valueData.setFlag(flag);



        if(valueData.getFlag() == "1")
        {
            con = new conData(fan1, fan2, motor,led,time,times,fan1_pwm,fan2_pwm,led_pwm);
            result = dao.addConData(con, request);

        }
//        if(Integer.parseInt(valueData.getFlag()) != 0)
//        {
//            con = new conData(fan1, fan2, motor,led,time,times);
//            result = dao.addConData(con, request);
//
//        }


        sen = new senData(tem, hum, light, time,times);
        result = dao.addSenData(sen, request);

        //      result = dao.addValueData(valueData, request);

        con = dao.findNearConData(request).get(0);
//        valueData = dao.findNearValueData(request).get(0);

//        out.print("!fan1:"+con.getFan1()+",fan2:"+con.getFan2()+",motor:"+con.getMotor()+",led:"+con.getLed()+",value1:"+valueData.getValue1()+",value2:"+valueData.getValue2()+",value3:"+valueData.getValue3()+",flag:"+valueData.getFlag()+",!");

        out.print("!fan1:"+con.getFan1()+",fan2:"+con.getFan2()+",fan1_pwm:"+con.getFan1_pwm()+",fan2_pwm:"+con.getFan2_pwm()+",pwm_led:"+con.getLed_pwm()+",motor:"+con.getMotor()+",led:"+con.getLed()+",value1:"+valueData.getValue1()+",value2:"+valueData.getValue2()+",value3:"+valueData.getValue3()+",flag:"+valueData.getFlag()+",!");

//        out.print("!fan1:"+con.getFan1()+",fan2:"+con.getFan2()+",motor:"+con.getMotor()+",led:"+con.getLed()+",fan1_pwm:"+con.getFan1_pwm()+",fan2_pwm:"+con.getFan2_pwm()+",value1:"+valueData.getValue1()+",value2:"+valueData.getValue2()+",value3:"+valueData.getValue3()+",flag:"+valueData.getFlag()+",!");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tem,hum,light,fan1,fan2,motor,led,time,times,value1,value2,value3,flag,fan1_pwm,fan2_pwm,led_pwm;


        DataDao dao = new DataDao();
        senData sen = null;
        conData con = null;
        valueData valueData = null;


        int result = 0;
        PrintWriter out = response.getWriter();
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);



        tem = request.getParameter("tem");
        hum = request.getParameter("hum");
        light = request.getParameter("light");
        fan1 = request.getParameter("fan1");
        fan2 = request.getParameter("fan2");
        motor = request.getParameter("motor");
        led = request.getParameter("led");
        flag = request.getParameter("flag");
        fan1_pwm = request.getParameter("fan1_pwm");
        fan2_pwm = request.getParameter("fan2_pwm");
        led_pwm = request.getParameter("led_pwm");

        valueData = dao.findNearValueData(request).get(0);
//        valueData.setFlag(flag);



        if(valueData.getFlag() == "1")
        {
            con = new conData(fan1, fan2, motor,led,time,times,fan1_pwm,fan2_pwm,led_pwm);
            result = dao.addConData(con, request);

        }
//        if(Integer.parseInt(valueData.getFlag()) != 0)
//        {
//            con = new conData(fan1, fan2, motor,led,time,times);
//            result = dao.addConData(con, request);
//
//        }


        sen = new senData(tem, hum, light, time,times);
        result = dao.addSenData(sen, request);

  //      result = dao.addValueData(valueData, request);

        con = dao.findNearConData(request).get(0);
//        valueData = dao.findNearValueData(request).get(0);

//        out.print("!fan1:"+con.getFan1()+",fan2:"+con.getFan2()+",motor:"+con.getMotor()+",led:"+con.getLed()+",value1:"+valueData.getValue1()+",value2:"+valueData.getValue2()+",value3:"+valueData.getValue3()+",flag:"+valueData.getFlag()+",!");

        out.print("!fan1:"+con.getFan1()+",fan2:"+con.getFan2()+",fan1_pwm:"+con.getFan1_pwm()+",fan2_pwm:"+con.getFan2_pwm()+",pwm_led:"+con.getLed_pwm()+",motor:"+con.getMotor()+",led:"+con.getLed()+",value1:"+valueData.getValue1()+",value2:"+valueData.getValue2()+",value3:"+valueData.getValue3()+",flag:"+valueData.getFlag()+",!");

//        out.print("!fan1:"+con.getFan1()+",fan2:"+con.getFan2()+",motor:"+con.getMotor()+",led:"+con.getLed()+",fan1_pwm:"+con.getFan1_pwm()+",fan2_pwm:"+con.getFan2_pwm()+",value1:"+valueData.getValue1()+",value2:"+valueData.getValue2()+",value3:"+valueData.getValue3()+",flag:"+valueData.getFlag()+",!");

    }
}
