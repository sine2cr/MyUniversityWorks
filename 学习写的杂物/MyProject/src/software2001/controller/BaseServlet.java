package software2001.controller;

import software2001.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodStr = req.getParameter(Constants.TAG);
        if(methodStr == null&&methodStr.equals("")){
            methodStr = Constants.INDEX;
        }

        Class clazz = this.getClass();

        try {
            Method method = clazz.getMethod(methodStr,HttpServletRequest.class, HttpServletResponse.class);

            Object result = method.invoke(this,req,resp);

            if (result != null) {
                String str = (String) result;
                if(str.startsWith(Constants.FORWARD)){
                    String path = str.substring(str.indexOf(Constants.FLAG)+1);
                    req.getRequestDispatcher(path).forward(req,resp);
                }else if(str.startsWith(Constants.REDIRECT)){
                    String path = str.substring(str.indexOf(Constants.FLAG)+1);
                    resp.sendRedirect(path);
                }else {
                    resp.getWriter().println(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String index(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.getWriter().println("注册业务逻辑");

        return Constants.FORWARD+"/index.jsp";
    }
}
