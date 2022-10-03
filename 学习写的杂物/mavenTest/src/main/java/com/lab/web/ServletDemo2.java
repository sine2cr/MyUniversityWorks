package com.lab.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet( urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init start");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /*
    * 会自动执行
    *
    * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servletdemo2 runing");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 内存释放或服务器关闭的时候会销毁servlet对象
     */
    @Override
    public void destroy() {

    }
}
