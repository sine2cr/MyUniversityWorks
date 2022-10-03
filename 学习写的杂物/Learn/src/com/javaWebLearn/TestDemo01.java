package com.javaWebLearn;

import cn.lib.lib;
import com.pojo.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDemo01 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/laboratory_113a";
        String username = "root";
        String password = "12345678";
        int test = 1;
        List<Account> list = new ArrayList<>();
        Connection lib = DriverManager.getConnection(url, username, password);
//        String sql = "select * from studentinfo";
        String sql = "select * from studentinfo where ID = ? ";
        PreparedStatement sss = lib.prepareStatement(sql);
        sss.setInt(1, test);
        System.out.println(lib);
        ResultSet str = sss.executeQuery();

//        Statement sss = lib.createStatement();
//        ResultSet str = sss.executeQuery(sql);
        while (str.next()) {
            Account account = new Account();
            System.out.println(str);
//            System.out.println(str.getInt(1));
//            System.out.println(str.getString(2));
//            System.out.println(str.getString(3));
            System.out.println("+++++++++=====++=========================+++++++++++");
//            System.out.println(str.getInt("ID"));
//            System.out.println(str.getString("Snamber"));
//            System.out.println(str.getString("Sname"));

            account.setID(str.getInt("ID"));
            account.setSnamber(str.getString("Snamber"));
            account.setSname(str.getString("Sname"));
            list.add(account);

        }
        System.out.println(list);
        sss.close();
        lib.close();

    }
}
