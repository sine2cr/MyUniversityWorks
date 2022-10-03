package software2001.filter;

import software2001.entity.Human;
import software2001.service.HumanService;
import software2001.service.impl.HumanServiceImpl;
import software2001.utils.Base64Utils;
import software2001.utils.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter("/login.jsp")
public class AutoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String content = null;
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(Constants.AUTO_NAME)){
                    content = cookie.getValue();
                }
            }
            if (content != null) {
                String[] split = content.split(Constants.FLAG);
                String username = split[0];
                String password = split[1];

                HumanService humanService = new HumanServiceImpl();
            try {
                Human human = humanService.login(username,password);
                if(human !=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("loginHuman",human);
                    HttpServletResponse response = (HttpServletResponse) servletResponse;

                    response.sendRedirect(request.getContextPath()+"main.jsp");
                }else {
                    filterChain.doFilter(servletRequest,servletResponse);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
