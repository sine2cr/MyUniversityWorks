package software2001.service.impl;

import software2001.dao.ManagerDao;
import software2001.dao.impl.ManagerDaoImpl;
import software2001.entity.ClockTime;
import software2001.entity.Manager;
import software2001.entity.Page;
import software2001.service.ManagerService;
import software2001.utils.DbUtils;

import java.time.Clock;
import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    @Override
    public Manager managerLogin(String username, String password) {
        ManagerDao managerDao = new ManagerDaoImpl();
        Manager manager = null;
        try {
            DbUtils.begin();
           manager = managerDao.selectManagerByUsername(username);
           if(manager!=null&&manager.getPassword().equals(password)){
               return manager;
           }
           DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return manager;
    }

    @Override
    public List<ClockTime> showAllByPage(Page page) {
        ManagerDao managerDao = new ManagerDaoImpl();
        List<ClockTime> list = null;
        try {
            DbUtils.begin();
            long count =managerDao.selectCount();
            page.setTotalCounts((int)count);
            list = managerDao.showClockTime(page);
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return list;
    }
}
