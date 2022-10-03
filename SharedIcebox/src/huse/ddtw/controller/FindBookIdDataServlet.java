package huse.ddtw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.borrowData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindBookIdDataServlet")
public class FindBookIdDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        DataDao dao = new DataDao();


        String time = request.getParameter("time");
        String bookId = request.getParameter("bookId");

        List<borrowData> borrowDataist  = dao.findBorrowHistoryByBookId(time,bookId,request);
        if (borrowDataist!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(borrowDataist);
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

        String bookId = request.getParameter("bookId");
        String time = request.getParameter("time");
                List<borrowData> borrowDataList  = dao.findBorrowHistoryByBookId(time,bookId,request);
        if (borrowDataList!=null){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(borrowDataList);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();
    }
}