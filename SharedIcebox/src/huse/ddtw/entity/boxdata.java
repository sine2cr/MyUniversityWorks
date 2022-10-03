package huse.ddtw.entity;

public class boxdata {
    private  String VID;
    private String PID;
    private String time;
    private String times;

    public boxdata() {
    }

    public String getVID() {
        return VID;
    }

    public void setVID(String VID) {
        this.VID = VID;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public boxdata(String VID, String PID, String time, String times) {
        this.VID = VID;
        this.PID = PID;
        this.time = time;
        this.times = times;
    }
}
