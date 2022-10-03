package software2001.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import software2001.dao.ManagerDao;
import software2001.entity.ClockTime;
import software2001.entity.Human;
import software2001.entity.Manager;
import software2001.entity.Page;
import software2001.utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao {

    @Override
    public Manager selectManagerByUsername(String username) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from manager where username = ?;";
        try {
            Manager manager= queryRunner.query(DbUtils.getConnection(), sql, new BeanHandler<Manager>(Manager.class), username);
            return manager;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<ClockTime> showClockTime(Page page) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select c_name ,beginTime,endTime from clockTime limit ?,?;";
        List<ClockTime> list = null;
        try {
            list = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<ClockTime>(ClockTime.class),page.getStartRow(),page.getPageSize());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }

    @Override
    public long selectCount() {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select count(*) from clockTime;";
        try {
            long count = (long) queryRunner.query(DbUtils.getConnection(), sql, new ScalarHandler());
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
