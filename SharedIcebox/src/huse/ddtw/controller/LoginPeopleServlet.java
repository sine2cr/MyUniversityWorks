package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.peopleData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoginPeopleServlet")
public class LoginPeopleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nameId,times;
        DataDao dao = new DataDao();
        peopleData peopleData = new peopleData();
        PrintWriter printWriter = response.getWriter();
        int result = 0;

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);


        nameId = request.getParameter("nameId");

        peopleData = new peopleData(nameId,times);
        result = dao.peopleLogin(peopleData, request);

        printWriter.print("Status:"+result);
    }
}
