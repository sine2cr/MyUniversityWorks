package software2001.service;

import software2001.entity.ClockTime;
import software2001.entity.Manager;
import software2001.entity.Page;

import java.util.List;

public interface ManagerService {

    Manager managerLogin(String username,String password);
    List<ClockTime> showAllByPage(Page page);
}
