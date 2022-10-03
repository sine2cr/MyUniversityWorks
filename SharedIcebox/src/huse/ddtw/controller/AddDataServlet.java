package huse.ddtw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.conData;
import huse.ddtw.entity.senData;
import huse.ddtw.entity.valueData;
import huse.ddtw.entity.Data;

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

@WebServlet(name = "AddDataServlet")
public class AddDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tem,hum,light,fan1,fan2,motor,led,time,value1,value2,value3,times;


        String json = "{}";
        DataDao dao = new DataDao();
        senData sen = null;
        conData con = null;
        valueData value = null;
        int result = 0;
        PrintWriter printWriter = response.getWriter();

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
        value1 = request.getParameter("value1");
        value2 = request.getParameter("value2");
        value3 = request.getParameter("value3");



        sen = new senData(tem, hum, light, time,times);
        con = new conData(fan1,fan2,motor,led,time,times);
        value = new valueData(value1, value2, value3, time,times);
        if (dao.addSenData(sen, request)==1)
            if (dao.addConData(con, request)==1)
                if (dao.addValueData(value, request)==1)
                    result = 1;
                else result = 0;
            else result = 0;
        else result = 0;






        List<Data> DataList  = dao.findData(request);
        if (DataList!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(DataList);
        }
        response.setContentType("application/json;charset=utf-8");

        printWriter.println(json);
        printWriter.flush();
        printWriter.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tem,hum,light,fan1,fan2,motor,led,time,value1,value2,value3,times,flag;


        String json = "{}";
        DataDao dao = new DataDao();
        senData sen = null;
        conData con = null;
        valueData value = null;
        int result = 0;
        PrintWriter printWriter = response.getWriter();

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
        value1 = request.getParameter("value1");
        value2 = request.getParameter("value2");
        value3 = request.getParameter("value3");
        flag = request.getParameter("flag");



        sen = new senData(tem, hum, light, time,times);
        con = new conData(fan1,fan2,motor,led,time,times);
        value = new valueData(value1, value2, value3,flag, time,times);
        if (dao.addSenData(sen, request)==1)
            if (dao.addConData(con, request)==1)
                if (dao.addValueData(value, request)==1)
                    result = 1;
                else result = 0;
            else result = 0;
        else result = 0;






        List<Data> DataList  = dao.findData(request);
        if (DataList!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(DataList);
        }


        response.setContentType("application/json;charset=utf-8");
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();

    }
}
