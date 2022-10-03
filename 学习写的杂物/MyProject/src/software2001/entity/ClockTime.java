package software2001.entity;

import java.util.Date;

public class ClockTime {
    private String c_name;
    private Date beginTime;
    private Date endTime;

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public ClockTime(String c_name, Date beginTime, Date endTime) {
        this.c_name = c_name;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public ClockTime() {
    }
}
