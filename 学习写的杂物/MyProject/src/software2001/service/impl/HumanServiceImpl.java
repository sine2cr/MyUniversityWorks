package software2001.service.impl;

import software2001.dao.HumanDao;
import software2001.dao.impl.HumanDaoImpl;
import software2001.entity.ClockTime;
import software2001.entity.Human;
import software2001.service.HumanService;
import software2001.utils.Constants;
import software2001.utils.DbUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class HumanServiceImpl implements HumanService {

    @Override
    public int registerHuman(Human human) {
        HumanDao humanDao = new HumanDaoImpl();
         int result = 0;
        try{
            DbUtils.begin();
             result = humanDao.insertHuman(human);
             DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Human login(String username, String password) {
        HumanDao humanDao = new HumanDaoImpl();
        Human human = null;
        try {
            DbUtils.begin();
            human = humanDao.selectHumanByHname(username);
            if(human!=null&&human.getPassword().equals(password)){
                return human;
            }
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }

        return human;
    }

    @Override
    public void addHumanClockTime(ClockTime clockTime) {
        HumanDao humanDao = new HumanDaoImpl();
        try {
            DbUtils.begin();
            humanDao.insertClockTime(clockTime);
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void updateByName(String name, Date endTime) {
        HumanDao humanDao = new HumanDaoImpl();
        try {
            DbUtils.begin();
            humanDao.updateEndTimeByName(name,endTime);
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
    }
}
