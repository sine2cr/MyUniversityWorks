package com.example.management113a.pojo;


public class StudentTime {
    private String startTime;
    private String endTime;
    private String snumber;
    private String id;

    public StudentTime() {

    }

    public StudentTime(String snumber) {
        this.snumber = snumber;
    }

    public StudentTime(String startTime, String endTime, String snumber) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.snumber = snumber;
    }

    public StudentTime(String startTime, String endTime, String snumber, String id) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.snumber = snumber;
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentTime{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", snumber='" + snumber + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
