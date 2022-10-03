package software2001.dao;

import software2001.entity.ClockTime;
import software2001.entity.Human;

import java.util.Date;

public interface HumanDao {
    int insertHuman(Human human);

    Human selectHumanByHname(String username);

    void insertClockTime(ClockTime clockTime);

    void updateEndTimeByName(String name, Date endTime);
}
