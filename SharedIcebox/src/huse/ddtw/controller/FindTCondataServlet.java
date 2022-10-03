package huse.ddtw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.conData;
import huse.ddtw.entity.senData;
import huse.ddtw.entity.t_condata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindTCondataServlet")
public class FindTCondataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String json = "{}";
        DataDao dao = new DataDao();


        List<t_condata> t_condata  = dao.findNeart_condata(request);
        if (t_condata!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(t_condata);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String json = "{}";
        DataDao dao = new DataDao();


        List<t_condata> t_condata  = dao.findNeart_condata(request);
        if (t_condata!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(t_condata);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();
    }
}
