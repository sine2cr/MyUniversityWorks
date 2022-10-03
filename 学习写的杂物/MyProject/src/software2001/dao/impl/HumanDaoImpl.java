package software2001.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import software2001.dao.HumanDao;
import software2001.entity.ClockTime;
import software2001.entity.Human;
import software2001.utils.DbUtils;

import java.sql.SQLException;
import java.util.Date;

public class HumanDaoImpl implements HumanDao {
    @Override
    public int insertHuman(Human human) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into human(username,password,age,sex) value(?,?,?,?);";

        try {
            int result = queryRunner.update(DbUtils.getConnection(), sql, human.getUsername(), human.getPassword(), human.getAge(), human.getSex());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Human selectHumanByHname(String username) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from human where username = ?;";
        try {
            Human human = queryRunner.query(DbUtils.getConnection(), sql, new BeanHandler<Human>(Human.class), username);
            return human;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertClockTime(ClockTime clockTime) {
       QueryRunner queryRunner = new QueryRunner();
       String sql = "insert into clockTime values(?,?,?);";
        try {
            queryRunner.update(DbUtils.getConnection(),sql,clockTime.getC_name(),clockTime.getBeginTime(),clockTime.getEndTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEndTimeByName(String name, Date endTime) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update clockTime set endTime = ? where c_name = ?;";
        try {
            queryRunner.update(DbUtils.getConnection(),sql,endTime,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
