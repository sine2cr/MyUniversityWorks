package huse.ddtw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.t_condata;
import huse.ddtw.entity.t_sendata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindTSenDataServlet")
public class FindTSenDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String json = "{}";
        DataDao dao = new DataDao();


        List<t_sendata> t_sendata  = dao.findNeart_sendata(request);
        if (t_sendata!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(t_sendata);
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


        List<t_sendata> t_sendata  = dao.findNeart_sendata(request);
        if (t_sendata!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(t_sendata);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();
    }
}
