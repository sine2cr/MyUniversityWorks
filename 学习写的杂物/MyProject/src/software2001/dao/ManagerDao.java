package software2001.dao;

import software2001.entity.ClockTime;
import software2001.entity.Manager;
import software2001.entity.Page;

import java.util.List;

public interface ManagerDao {
    Manager selectManagerByUsername(String username);
    List<ClockTime> showClockTime(Page page);
    long selectCount();
}
