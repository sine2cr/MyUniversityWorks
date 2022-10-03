package huse.ddtw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import huse.ddtw.dao.DataDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import huse.ddtw.entity.Data;
import java.util.List;

@WebServlet(name = "FindDataServlet")
public class FindDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String json = "{}";
        DataDao dao = new DataDao();


        List<Data> DataList  = dao.findData(request);
        if (DataList!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(DataList);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();
    }
}
