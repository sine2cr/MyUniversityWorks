package huse.ddtw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.smokeData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindNearSmokeDataServlet")
public class FindNearSmokeDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        DataDao dao = new DataDao();

        String time = request.getParameter("time");
        List<smokeData> smokeDataList  = dao.findSomkeData(request);
        if (smokeDataList!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(smokeDataList);
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

        String time = request.getParameter("time");
        List<smokeData> smokeDataList  = dao.findSomkeData(request);
        if (smokeDataList!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(smokeDataList);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();
    }
}
