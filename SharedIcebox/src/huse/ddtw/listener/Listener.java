package huse.ddtw.listener;

import huse.ddtw.util.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil util = new JdbcUtil();
        Map map = new HashMap();
        for (int i=1;i<10;i++){
            Connection con = util.getCon();
            map.put(con,true);

        }
        ServletContext application = sce.getServletContext();
        application.setAttribute("con", map);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map =(Map)application.getAttribute("con");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            Connection con = (Connection)it.next();
            if (con != null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
