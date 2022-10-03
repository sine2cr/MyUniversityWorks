package huse.ddtw.entity;

public class temData {
    private String tem;
    private String time;
    private String times;

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public temData(String tem, String time, String times) {
        this.tem = tem;
        this.time = time;
        this.times = times;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public temData(String tem, String time) {
        this.tem = tem;
        this.time = time;
    }

    public temData() {
    }
}
