package software2001.service;

import software2001.entity.ClockTime;
import software2001.entity.Human;

import java.util.Date;

public interface HumanService {
    int registerHuman(Human human);

    Human login(String username, String password);


    void addHumanClockTime(ClockTime clockTime);

    void updateByName(String name, Date endTime);
}
