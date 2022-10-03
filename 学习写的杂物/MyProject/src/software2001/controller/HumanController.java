package software2001.controller;

import org.apache.commons.beanutils.BeanUtils;
import software2001.entity.ClockTime;
import software2001.entity.Human;
import software2001.service.HumanService;
import software2001.service.impl.HumanServiceImpl;
import software2001.utils.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet("/human")
public class HumanController extends BaseServlet{

    public String register(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        HumanService humanService = new HumanServiceImpl();

        Map<String, String[]> parameterMap = request.getParameterMap();
        Human human = new Human();

        BeanUtils.populate(human,parameterMap);


        int result = humanService.registerHuman(human);

        return  Constants.FORWARD+"registerSuccess.jsp";
    }
    public String login(HttpServletRequest request, HttpServletResponse response){
        HumanService humanService = new HumanServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String auto = request.getParameter("auto");

        String codeStr = (String) request.getSession().getAttribute("code");
        if(code == null||!code.equalsIgnoreCase(codeStr)){
            return Constants.FORWARD+"/login.jsp";
        }
        Human human = humanService.login(username,password);
        if (human == null) {
            return Constants.FORWARD+"/login.jsp";
        }

        request.getSession().setAttribute("loginHuman",human);
        if (auto == null) {
            Cookie cookie = new Cookie(Constants.AUTO_NAME,"");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }else {
            String content = username+Constants.FLAG+password;
            Cookie cookie = new Cookie(Constants.AUTO_NAME,content);
            cookie.setPath("/");
            cookie.setMaxAge(14*24*60*60);
            response.addCookie(cookie);
        }
        return Constants.REDIRECT+"/main.jsp";
    }
    public String loginOut(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("loginHuman");

        Cookie cookie = new Cookie(Constants.AUTO_NAME,"");
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        return Constants.FORWARD+"login.jsp";
    }
    public String clockBeginSuccess(HttpServletRequest request, HttpServletResponse response){
         HumanService humanService = new HumanServiceImpl();
        String name = request.getParameter("name");
        ClockTime clockTime = new ClockTime(name,new Date(),null);
        humanService.addHumanClockTime(clockTime);
        return Constants.FORWARD+"/clockBeginSuccess.jsp";
    }
    public String clockEndSuccess(HttpServletRequest request, HttpServletResponse response){
        HumanService humanService = new HumanServiceImpl();
        String name = request.getParameter("name");
        Date endTime = new Date();
        humanService.updateByName(name,endTime);
        return Constants.FORWARD+"/clockEndSuccess.jsp";
    }
}
