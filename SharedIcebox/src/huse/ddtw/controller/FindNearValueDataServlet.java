package huse.ddtw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.valueData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindNearValueDataServlet")
public class FindNearValueDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String json = "{}";
        DataDao dao = new DataDao();


        List<valueData> valueDataList  = dao.findNearValueData(request);
        if (valueDataList!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(valueDataList);
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


        List<valueData> valueDataList  = dao.findNearValueData(request);
        if (valueDataList!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(valueDataList);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();
    }
}
