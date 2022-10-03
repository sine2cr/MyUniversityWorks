package huse.ddtw.dao;

import huse.ddtw.entity.*;
import huse.ddtw.util.JdbcUtil;


import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDao {

    private JdbcUtil util = new JdbcUtil();

    //新增所有传感器数据
    public int addSenData(senData senData,HttpServletRequest request){
        String sql = "insert into sendata(tem,hum,light,time,times) values(?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, senData.getTem());
            ps.setString(2, senData.getHum());
            ps.setString(3, senData.getLight());
            ps.setString(4, senData.getTime());
            ps.setString(5, senData.getTimes());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    //新增所有控制器数据
    public int addConData(conData conData,HttpServletRequest request){
        String sql = "insert into condata(fan1,fan2,motor,led,time,times,fan1_pwm,fan2_pwm,led_pwm) value(?,?,?,?,?,?,0,0,0)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, conData.getFan1());
            ps.setString(2, conData.getFan2());
            ps.setString(3, conData.getMotor());
            ps.setString(4, conData.getLed());
            ps.setString(5, conData.getTime());
            ps.setString(6, conData.getTimes());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    //新增所有控制器数据
    public int addCon_pwmData(conData conData,HttpServletRequest request){
        String sql = "insert into condata(fan1,fan2,motor,led,time,times,fan1_pwm,fan2_pwm,led_pwm) value(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, conData.getFan1());
            ps.setString(2, conData.getFan2());
            ps.setString(3, conData.getMotor());
            ps.setString(4, conData.getLed());
            ps.setString(5, conData.getTime());
            ps.setString(6, conData.getTimes());
            ps.setString(7, conData.getFan1_pwm());
            ps.setString(8, conData.getFan2_pwm());
            ps.setString(9, conData.getLed_pwm());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    //新增阈值数据
    public int addValueData(valueData valueData,HttpServletRequest request){
        String sql = "insert into valuedata(value1,value2,value3,time,times,flag) value(?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, valueData.getValue1());
            ps.setString(2, valueData.getValue2());
            ps.setString(3, valueData.getValue3());
            ps.setString(4, valueData.getTime());
            ps.setString(5, valueData.getTimes());
            ps.setString(6, valueData.getFlag());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }



    //获取最近时间的传感器数据
    public List<senData> findNearSenData(HttpServletRequest request){
        String sql = "select * from sendata where times=(select max(times)from sendata)";
        PreparedStatement ps = util.createStatement(sql,request);
        ResultSet rs = null;
        List<senData> results = new ArrayList();


        try {
                rs = ps.executeQuery();
                while(rs.next()) {
                    String tem = rs.getString("tem");
                    String hum = rs.getString("hum");
                    String light = rs.getString("light");
                    String time = rs.getString("time");
                    String times = rs.getString("times");
                    senData senData = new senData(tem, hum, light, time,times);
                    results.add(senData);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //获取最近时间的控制器数据
    public List<conData> findNearConData(HttpServletRequest request){
        String sql = "select * from condata where times=(select max(times)from condata)";
        PreparedStatement ps = util.createStatement(sql,request);
        ResultSet rs = null;
        List<conData> results =new ArrayList();

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String fan1 = rs.getString("fan1");
                String fan2 = rs.getString("fan2");
                String motor = rs.getString("motor");
                String led = rs.getString("led");
                String fan1_pwm = rs.getString("fan1_pwm");
                String fan2_pwm = rs.getString("fan2_pwm");
                String led_pwm = rs.getString("led_pwm");
                String time1 = rs.getString("time");
                String times = rs.getString("times");
                conData conData = new conData(fan1, fan2, motor,led,time1,times, fan1_pwm,fan2_pwm,led_pwm);
                results.add(conData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //获取最近时间的阈值数据
    public List<valueData> findNearValueData(HttpServletRequest request){
        String sql = "select * from valuedata where times=(select max(times) from valuedata)";
        PreparedStatement ps = util.createStatement(sql,request);
        ResultSet rs = null;
        List<valueData> results =new ArrayList();

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String value1 = rs.getString("value1");
                String value2 = rs.getString("value2");
                String value3 = rs.getString("value3");
                String time = rs.getString("time");
                String times = rs.getString("times");
                String flag = rs.getString("flag");
                valueData valueData = new valueData(value1, value2, value3,flag, time,times);
                results.add(valueData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }


    //获取某个时间点后传感器的所有数据
    public List<senData> findSenData(String time, HttpServletRequest request){
        String sql = "select tem,hum,light,time,times from sendata where id>=(select min(id) from sendata where time =?)";
        PreparedStatement ps = util.createStatement(sql,request);
        List<senData> results = new ArrayList();
        ResultSet rs = null;

        try {
            ps.setString(1, time);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tem = rs.getString("tem");
                String hum = rs.getString("hum");
                String light = rs.getString("light");

                String time1 = rs.getString("time");
                String times = rs.getString("times");
                senData senData = new senData(tem, hum, light, time1,times);
                results.add(senData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //获取某个时间点后控制器的所有数据
    public List<conData> findConData(String time, HttpServletRequest request){
        String sql = "select fan1,fan2,motor,led,fan1_pwm,fan2_pwm,led_pwm,time,times from condata where id>=(select min(id) from condata where time=?)";
        PreparedStatement ps = util.createStatement(sql,request);
        List<conData> results = new ArrayList();
        ResultSet rs = null;

        try {
            ps.setString(1, time);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fan1 = rs.getString("fan1");
                String fan2 = rs.getString("fan2");
                String motor = rs.getString("motor");
                String led = rs.getString("led");
                String fan1_pwm = rs.getString("fan1_pwm");
                String fan2_pwm = rs.getString("fan2_pwm");
                String led_pwm = rs.getString("led_pwm");
                String time1 = rs.getString("time");
                String times = rs.getString("times");
                conData conData = new conData(fan1, fan2, motor,led,time1,times, fan1_pwm,fan2_pwm,led_pwm);
                results.add(conData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //获取某个时间点后控制器的所有数据
    public List<valueData> findValueData(String time, HttpServletRequest request){
        String sql = "select value1,value2,value3,time,times,flag from valuedata where id>=(select min(id) from valuedata where time=?)";
        PreparedStatement ps = util.createStatement(sql,request);
        List<valueData> results = new ArrayList();
        ResultSet rs = null;

        try {
            ps.setString(1, time);
            rs = ps.executeQuery();
            while (rs.next()) {
                String value1 = rs.getString("value1");
                String value2 = rs.getString("value2");
                String value3 = rs.getString("value3");
                String time1 = rs.getString("time");
                String times = rs.getString("times");
                String flag = rs.getString("flag");
                valueData valueData = new valueData(value1, value2, value3,flag, time1,times);
                results.add(valueData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }


    //获取某个时间点后温度传感器的所有数据
    public List<temData> findTemData(String time, HttpServletRequest request){
        String sql = "select tem,time,times from sendata where id>=(select min(id) from sendata where time =?)";
        PreparedStatement ps = util.createStatement(sql,request);
        List<temData> results = new ArrayList();
        ResultSet rs = null;

        try {
            ps.setString(1, time);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tem = rs.getString("tem");
                String time1 = rs.getString("time");
                String times = rs.getString("times");
                temData temData = new temData(tem,time1,times);
                results.add(temData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //获取某个时间点后湿度传感器的所有数据
    public List<humData> findHumData(String time, HttpServletRequest request){
        String sql = "select hum,time,times from sendata where id>=(select min(id) from sendata where time =?)";
        PreparedStatement ps = util.createStatement(sql,request);
        List<humData> results = new ArrayList();
        ResultSet rs = null;

        try {
            ps.setString(1, time);
            rs = ps.executeQuery();
            while (rs.next()) {
                String hum = rs.getString("hum");
                String time1 = rs.getString("time");
                String times = rs.getString("times");
                humData humData = new humData(hum,time1,times);
                results.add(humData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //获取某个时间点后光照传感器的所有数据
    public List<lightData> findLightData(String time, HttpServletRequest request){
        String sql = "select light,time,times from sendata where id>=(select min(id) from sendata where time =?)";
        PreparedStatement ps = util.createStatement(sql,request);
        List<lightData> results = new ArrayList();
        ResultSet rs = null;

        try {
            ps.setString(1, time);
            rs = ps.executeQuery();
            while (rs.next()) {
                String light = rs.getString("light");
                String time1 = rs.getString("time");
                String times = rs.getString("times");
                lightData lightData = new lightData(light,time1,times);
                results.add(lightData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }

    //获取最新的数据
    public List<Data> findData(HttpServletRequest request){
        String sql = "select * from (select tem,hum,light,time,times from sendata where times=(select max(times)from sendata)) s,(select fan1,fan2,motor,led,fan1_pwm,fan2_pwm,led_pwm,times from condata where times=(select max(times)from condata)) c,(select value1,value2,value3,times,flag from valuedata where times=(select max(times)from valuedata)) v";
        PreparedStatement ps = util.createStatement(sql,request);
        List<Data> results = new ArrayList();
        ResultSet rs = null;

        try {

            rs = ps.executeQuery();
            rs.next();
                String tem = rs.getString("tem");
                String hum = rs.getString("hum");
                String light = rs.getString("light");

                String fan1 = rs.getString("fan1");
                String fan2 = rs.getString("fan2");
                String motor = rs.getString("motor");
                String led = rs.getString("led");
                String fan1_pwm = rs.getString("fan1_pwm");
                String fan2_pwm = rs.getString("fan2_pwm");
                String led_pwm = rs.getString("led_pwm");

                String value1 = rs.getString("value1");
                String value2 = rs.getString("value2");
                String value3 = rs.getString("value3");
                String flag = rs.getString("flag");

                String time1 = rs.getString("time");
                String times = rs.getString("s.times");
                String times1 = rs.getString("c.times");
                String times2 = rs.getString("v.times");

                if (times.compareTo(times1)>0)
                    if (times.compareTo(times2)>0)
                        times=times;
                    else
                        times=times2;
                    else if (times1.compareTo(times2)>0)
                        times=times1;
                    else
                        times=times2;

                Data data = new Data(tem,hum,light,fan1,fan2,motor,led,value1, value2, value3,flag,fan1_pwm,fan2_pwm,led_pwm,time1,times);
                results.add(data);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }




    //图书馆管理系统
    //上传烟雾传感器数据
    public int addSomkeData(smokeData smokeData, HttpServletRequest request){
        String sql = "insert into smokedata(smoke1,smoke2,times) values(?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, smokeData.getSmoke1());
            ps.setString(2, smokeData.getSmoke2());
            ps.setString(3, smokeData.getTimes());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    //上传f非法闯入数据
    public int addBreakinData(breakinData breakinData,HttpServletRequest request){
        String sql = "insert into breakindata(flag,ifbreakin,times) values(?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, breakinData.getFlag());
            ps.setString(2, breakinData.getIfbreakin());
            ps.setString(3, breakinData.getTimes());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    //添加人员身份信息
    public int addPeopleData(peopleData peopleData,HttpServletRequest request){
        String sql = "insert into peopledata(nameid,times) values(?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, peopleData.getNameId());
            ps.setString(2, peopleData.getTimes());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    //添加图书信息
    public int addBookData(bookData bookData,HttpServletRequest request){
        String sql = "insert into bookdata(bookid,bookname,location,times,time) values(?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, bookData.getBookID());
            ps.setString(2, bookData.getBookName());
            ps.setString(3, bookData.getLocation());
            ps.setString(4, bookData.getTimes());
            ps.setString(5, bookData.getTime());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    //添加图书借阅信息
    public int addBookBorrowData(borrowData borrowData,HttpServletRequest request){
        String sql = "insert into borrowdata(bookid,nameid,borrow,time,times) values(?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, borrowData.getBookId());
            ps.setString(2, borrowData.getNameId());
            ps.setString(3, borrowData.getBorrow());
            ps.setString(4, borrowData.getTime());
            ps.setString(5, borrowData.getTimes());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }

    //刷卡验证人员信息
    public int peopleLogin(peopleData peopleData,HttpServletRequest request){
        String sql = "select nameid from peopledata where nameid =?";
        PreparedStatement ps = util.createStatement(sql,request);
       int result = 0;
        ResultSet rs = null;

        try {
            ps.setString(1, peopleData.getNameId());
            rs = ps.executeQuery();
            while (rs.next()) {
                result = null==rs.getString("nameid")?0:1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return result;
    }

    //获取最新烟雾信息
    public List<smokeData> findSomkeData(HttpServletRequest request){
        String sql = "select * from smokedata where times =(select max(times) from smokedata)";
        PreparedStatement ps = util.createStatement(sql,request);
        ResultSet rs = null;
        List<smokeData> results =new ArrayList();

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String smoke1 = rs.getString("smoke1");
                String smoke2 = rs.getString("smoke2");
                String times = rs.getString("times");
                smokeData smokeData = new smokeData(smoke1, smoke2, times);
                results.add(smokeData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //获取最新非法闯入信息
    public List<breakinData> findBreakinData(HttpServletRequest request){
        String sql = "select * from breakindata where times =(select max(times) from breakindata)";
        PreparedStatement ps = util.createStatement(sql,request);
        ResultSet rs = null;
        List<breakinData> results =new ArrayList();

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String ifbreakin = rs.getString("ifbreakin");
                String times = rs.getString("times");
                breakinData breakinData = new breakinData(ifbreakin,times);
                results.add(breakinData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //获取最新的烟雾和非法闯入信息
    public List<smokeBreakData> findSmokeBreakData(HttpServletRequest request){
        String sql = "select * from (select ifbreakin,flag from breakindata where times =(select max(times) from breakindata)) b,(select * from smokedata where times =(select max(times) from smokedata)) s";
        PreparedStatement ps = util.createStatement(sql,request);
        ResultSet rs = null;
        List<smokeBreakData> results =new ArrayList();

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String smoke1 = rs.getString("smoke1");
                String smoke2 = rs.getString("smoke2");
                String flag = rs.getString("flag");
                String ifbreakin = rs.getString("ifbreakin");
                String times = rs.getString("times");
                smokeBreakData smokeBreakData = new smokeBreakData(smoke1,smoke2,flag,ifbreakin,times);
                results.add(smokeBreakData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //按书号和时间查询图书状态和借阅历史数据
    public List<bookData> findBookHistoryByBookId(String time,String bookId,HttpServletRequest request){
        String sql = "select * from (select * from bookdata where id>=(select min(id) from bookdata where time =?)) b where bookid=?";
        PreparedStatement ps = util.createStatement(sql,request);
        List<bookData> results = new ArrayList();
        ResultSet rs = null;

        try {

            ps.setString(1,time);
            ps.setString(2,bookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("bookid");
                String bookname = rs.getString("bookname");
                String location = rs.getString("location");
                String times = rs.getString("times");
                String time1 = rs.getString("time");
                bookData bookData = new bookData(bookid,bookname,location,times,time1);
                results.add(bookData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }

    //按书号和时间查询图书状态和借阅历史数据
    public List<borrowData> findBorrowHistoryByBookId(String time,String bookId,HttpServletRequest request){
        String sql = "select * from (select * from borrowdata where id>=(select min(id) from borrowdata where time =?)) b where bookid=?";
        PreparedStatement ps = util.createStatement(sql,request);
        List<borrowData> results = new ArrayList();
        ResultSet rs = null;

        try {

            ps.setString(1,time);
            ps.setString(2,bookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("bookid");
                String nameid = rs.getString("nameid");
                String borrow = rs.getString("borrow");
                String times = rs.getString("times");
                borrowData borrowData1 = new borrowData(bookid,nameid,borrow,times);
                results.add(borrowData1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }
    //按人员id和时间查询图书状态和借阅历史数据
    public List<borrowData> findBorrowHistoryByNameId(String time,String nameId,HttpServletRequest request){
        String sql = "select * from (select * from borrowdata where id>=(select min(id) from borrowdata where time =?)) b where nameid=?";
        PreparedStatement ps = util.createStatement(sql,request);
        List<borrowData> results = new ArrayList();
        ResultSet rs = null;

        try {
            ps.setString(1,time);
            ps.setString(2,nameId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("bookid");
                String nameid = rs.getString("nameid");
                String borrow = rs.getString("borrow");
                String times = rs.getString("times");
                borrowData borrowData1 = new borrowData(bookid,nameid,borrow,times);
                results.add(borrowData1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }

    //通过书的id判断书名
    public String ifBookName(String bookId){
        switch (bookId) {
            case "20210169":
                return "数字信号处理";
            case "20210182":
                return "信号与系统";
            case "20210122":
                return "信息论与编码";
            case "20210141":
                return "通信原理";
            default:
                return "0";
        }
    }
    //判断书是否已经被借走
    public int ifBookLocation(String bookId){
        String sql = "select  location from (select * from bookdata where bookid =?) a where times = (select max(times) from  (select * from bookdata where bookid =?) b)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        ResultSet rs = null;

        try {
            ps.setString(1, bookId);
            ps.setString(2, bookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getString("location").length()>2?1:0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return result;
    }

    //获取最新借书人信息
    public List<peopleData> findNearPeopleData(HttpServletRequest request){
        String sql = "select * from peopledata where times =(select max(times) from peopledata)";
        PreparedStatement ps = util.createStatement(sql,request);
        ResultSet rs = null;
        List<peopleData> results =new ArrayList();

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String nameid = rs.getString("nameid");
                String times = rs.getString("times");
                peopleData peopleData = new peopleData(nameid,times);
                results.add(peopleData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }


    public int addBoxData(boxdata boxdata, HttpServletRequest request){
        String sql = "insert into boxdata(VID,PID,times,time) values(?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, boxdata.getVID());
            ps.setString(2, boxdata.getPID());
            ps.setString(3, boxdata.getTimes());
            ps.setString(4, boxdata.getTime());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }

    public List<boxdata> findPIDHistoryByVID(String VID,HttpServletRequest request){
        String sql = "select * from boxdata where VID=?";
        PreparedStatement ps = util.createStatement(sql,request);
        List<boxdata> results = new ArrayList();
        ResultSet rs = null;

        try {
            ps.setString(1,VID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String VID1 = rs.getString("VID");
                String PID = rs.getString("PID");
                String time = rs.getString("time");
                String times = rs.getString("times");
                boxdata boxdata = new boxdata(VID1,PID,time,times);
                results.add(boxdata);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }

    public int addt_sendata(t_sendata t_sendata,HttpServletRequest request){
        String sql = "insert into t_sendata(Tin,Tout,LXin,VStatus,time,times) value(?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, t_sendata.getTin());
            ps.setString(2, t_sendata.getTout());
            ps.setString(3, t_sendata.getLXin());
            ps.setString(4, t_sendata.getVStatus());
            ps.setString(5, t_sendata.getTime());
            ps.setString(6, t_sendata.getTimes());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }

    public List<t_sendata> findNeart_sendata(HttpServletRequest request){
        String sql = "select * from t_sendata where times=(select max(times) from t_sendata)";
        PreparedStatement ps = util.createStatement(sql,request);
        List<t_sendata> results = new ArrayList();
        ResultSet rs = null;

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String Tin = rs.getString("Tin");
                String Tout = rs.getString("Tout");
                String LXin = rs.getString("LXin");
                String VStatus = rs.getString("VStatus");
                String time = rs.getString("time");
                String times = rs.getString("times");
                t_sendata t_sendata = new t_sendata(Tin,Tout,LXin,VStatus,time,times);
                results.add(t_sendata);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }


    public int addt_ValueData(t_valuedata t_valuedata,HttpServletRequest request){
        String sql = "insert into t_valuedata(TinDH,TinDL,TG,LXD,TBegin,TEnd,time,times) value(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, t_valuedata.getTinDH());
            ps.setString(2, t_valuedata.getTinDL());
            ps.setString(3, t_valuedata.getTG());
            ps.setString(4, t_valuedata.getLXD());
            ps.setString(5, t_valuedata.getTBegin());
            ps.setString(6, t_valuedata.getTEnd());
            ps.setString(7, t_valuedata.getTime());
            ps.setString(8, t_valuedata.getTimes());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }

    public List<t_valuedata> findNeart_valuedata(HttpServletRequest request){
        String sql = "select * from t_valuedata where times=(select max(times) from t_valuedata)";
        PreparedStatement ps = util.createStatement(sql,request);
        List<t_valuedata> results = new ArrayList();
        ResultSet rs = null;

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String TinDH = rs.getString("TinDH");
                String TinDL = rs.getString("TinDL");
                String TG = rs.getString("TG");
                String LXD = rs.getString("LXD");
                String TBegin = rs.getString("TBegin");
                String TEnd = rs.getString("TEnd");
                String time = rs.getString("time");
                String times = rs.getString("times");
                t_valuedata t_valuedata = new t_valuedata(TinDH,TinDL,TG,LXD,TBegin,TEnd,time,times);
                results.add(t_valuedata);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }

    public int addt_ConData(t_condata t_condata,HttpServletRequest request){
        String sql = "insert into t_condata(Bright,SpeedM1,SpeedM2,time,times) value(?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);

        int result = 0;
        try {
            ps.setString(1, t_condata.getBright());
            ps.setString(2, t_condata.getSpeedM1());
            ps.setString(3, t_condata.getSPeedM2());
            ps.setString(4, t_condata.getTime());
            ps.setString(5, t_condata.getTimes());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }

    public List<t_condata> findNeart_condata(HttpServletRequest request){
        String sql = "select * from t_condata where times=(select max(times) from t_condata)";
        PreparedStatement ps = util.createStatement(sql,request);
        List<t_condata> results = new ArrayList();
        ResultSet rs = null;

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String Bright = rs.getString("Bright");
                String SpeedM1 = rs.getString("SpeedM1");
                String SpeedM2 = rs.getString("SpeedM2");
                String time = rs.getString("time");
                String times = rs.getString("times");
                t_condata t_condata = new t_condata(Bright,SpeedM1,SpeedM2,time,times);
                results.add(t_condata);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }


    public List<TData> findTData(HttpServletRequest request){
        String sql = "select * from (select * from t_sendata where times=(select max(times)from t_sendata)) s,(select * from t_condata where times=(select max(times)from t_condata)) c,(select * from t_valuedata where times=(select max(times)from t_valuedata)) v";
        PreparedStatement ps = util.createStatement(sql,request);
        List<TData> results = new ArrayList();
        ResultSet rs = null;

        try {

            rs = ps.executeQuery();
            rs.next();
            String Tin = rs.getString("Tin");
            String Tout = rs.getString("Tout");
            String LXin = rs.getString("LXin");
            String VStatus = rs.getString("VStatus");

            String Bright = rs.getString("Bright");
            String SpeedM1 = rs.getString("SpeedM1");
            String SpeedM2 = rs.getString("SpeedM2");

            String TinDH = rs.getString("TinDH");
            String TinDL = rs.getString("TinDL");
            String TG = rs.getString("TG");
            String LXD = rs.getString("LXD");
            String TBegin = rs.getString("TBegin");
            String TEnd = rs.getString("TEnd");

            String time1 = rs.getString("time");
            String times = rs.getString("s.times");
            String times1 = rs.getString("c.times");
            String times2 = rs.getString("v.times");

            if (times.compareTo(times1)>0)
                if (times.compareTo(times2)>0)
                    times=times;
                else
                    times=times2;
            else if (times1.compareTo(times2)>0)
                times=times1;
            else
                times=times2;

            TData Tdata = new TData(Tin,Tout,LXin,VStatus,Bright,SpeedM1,SpeedM2,TinDH, TinDL, TG,LXD,TBegin,TEnd,time1,times);
            results.add(Tdata);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return results;
    }

}
