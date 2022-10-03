package com.druid;

import com.alibaba.druid.pool.*;
import com.pojo.Account;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DruidDemo {
    /*
     *druid连接池
     */

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/com/druid.properties.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        int txt = 2;
        List<Account> list = new ArrayList<>();

        String selectSql = "select * from studentinfo where ID=?";
        String select2Sql = "select * from studentinfo ";
        PreparedStatement sss = connection.prepareStatement(select2Sql);
//        sss.setInt(1, txt);
        ResultSet str = sss.executeQuery();
        while (str.next()) {
            Account acc = new Account();
            acc.setID(str.getInt("ID"));
            acc.setSnamber(str.getString("Snamber"));
            acc.setSname(str.getString("Sname"));
            list.add(acc);
        }
        Object[] list1 = list.toArray();

        for (int i = 0; i < list1.length; i++) {
            System.out.println(list1[i]);
        }
        System.out.println(list);

    }

}
