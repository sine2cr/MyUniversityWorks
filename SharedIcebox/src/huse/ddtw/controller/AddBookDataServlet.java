package huse.ddtw.controller;

import huse.ddtw.dao.DataDao;
import huse.ddtw.entity.bookData;
import huse.ddtw.entity.borrowData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@WebServlet(name = "AddBookDataServlet")
public class AddBookDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookId,bookName,location,time,times,borrow;
        String nameId;
        DataDao dao = new DataDao();
        bookData bookData = new bookData();
        borrowData borrowData = new borrowData();
        PrintWriter printWriter = response.getWriter();
        int result = 0;
        Random random = new Random();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);


        bookId = request.getParameter("bookId");

        nameId = dao.findNearPeopleData(request).get(0).getNameId();
        bookName = dao.ifBookName(bookId);
        location = (dao.ifBookLocation(bookId)==1)?"0":"203-D-A4-4-"+random.nextInt(30);
        borrow = dao.ifBookLocation(bookId)==1?"0":"1";

        bookData = new bookData(bookId,bookName,location,times);
        borrowData = new borrowData(bookId, nameId,borrow,time, times);
        result = dao.addBookData(bookData, request)==1&&dao.addBookBorrowData(borrowData, request)==1?1:0;


    //    printWriter.print("Status:"+result);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId,bookName,location,time,times,borrow;
        String nameId;
        DataDao dao = new DataDao();
        bookData bookData = new bookData();
        borrowData borrowData = new borrowData();
        PrintWriter printWriter = response.getWriter();
        int result = 0;
        Random random = new Random();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        times=sdf.format(nowTime);
        time= times.substring(0, 16);


        bookId = request.getParameter("bookId");

        nameId = dao.findNearPeopleData(request).get(0).getNameId();
        bookName = dao.ifBookName(bookId);
        location = (dao.ifBookLocation(bookId)==1)?"0":"203-D-A4-4-"+random.nextInt(30);
        borrow = dao.ifBookLocation(bookId)==1?"0":"1";

        bookData = new bookData(bookId,bookName,location,times,time);
        borrowData = new borrowData(bookId, nameId,borrow,time, times);
        result = dao.addBookData(bookData, request)==1&&dao.addBookBorrowData(borrowData, request)==1?1:0;


       // printWriter.print("Status:"+result);

    }
}
