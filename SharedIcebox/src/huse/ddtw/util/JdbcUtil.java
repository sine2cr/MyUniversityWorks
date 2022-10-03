package huse.ddtw.util;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JdbcUtil {
    final String URL = "jdbc:mysql://localhost:3306/iceBox";
    final String userName = "root";
    final String password = "12345678";
    PreparedStatement ps = null;
    java.sql.Connection con = null;


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        try {
            con = DriverManager.getConnection(URL, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;

    }

    public Connection getCon(HttpServletRequest request) {
        ServletContext application = request.getServletContext();

        Map map = (Map) application.getAttribute("con");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            con = (Connection) it.next();
            boolean flag = (boolean) map.get(con);
            if (flag == true) {
                map.put(con, false);
                break;
            }
        }
        return con;
    }

    public PreparedStatement createStatement(String sql) {
        try {
            ps = getCon().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;

    }

    public PreparedStatement createStatement(String sql, HttpServletRequest request) {
        try {
            ps = getCon(request).prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;

    }

    public void close() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void close(HttpServletRequest request) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        ServletContext application = request.getServletContext();
        Map map = (Map) application.getAttribute("con");
        map.put(con, true);
    }

    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close();
    }

    public void close(ResultSet rs, HttpServletRequest request) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(request);

    }

}

