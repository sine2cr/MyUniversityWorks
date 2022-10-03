package software2001.controller;

import software2001.entity.ClockTime;
import software2001.entity.Manager;
import software2001.entity.Page;
import software2001.service.ManagerService;
import software2001.service.impl.ManagerServiceImpl;
import software2001.utils.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/mmm")
public class ManagerController extends BaseServlet{
    public String managerlogin(HttpServletRequest request, HttpServletResponse response){
        ManagerService managerService = new ManagerServiceImpl();
        String username = request.getParameter("managerName");
        String password = request.getParameter("managerPassword");

        Manager manager = managerService.managerLogin(username, password);
        if (manager == null) {
            return Constants.FORWARD+"/login.jsp";
        }
        request.getSession().setAttribute("loginManager",manager);
        return Constants.REDIRECT+"/m.jsp";
    }
    public String showClockTime(HttpServletRequest request, HttpServletResponse response){
        String pageIndex = request.getParameter("pageIndex");
        if (pageIndex == null) {
            pageIndex = "1";
        }
        Page page = new Page(Integer.valueOf(pageIndex));

        ManagerService managerService = new ManagerServiceImpl();
        List<ClockTime> list = managerService.showAllByPage(page);
        request.setAttribute("list",list);
        request.setAttribute("page",page);


        return Constants.FORWARD+"/show.jsp";
    }
}
