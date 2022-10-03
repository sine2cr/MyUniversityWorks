package huse.ddtw.entity;

public class t_condata {
    private String Bright;
    private String SpeedM1;
    private String SPeedM2;
    private String  time;
    private  String times;

    public String getBright() {
        return Bright;
    }

    public void setBright(String bright) {
        Bright = bright;
    }

    public String getSpeedM1() {
        return SpeedM1;
    }

    public t_condata() {
    }

    public void setSpeedM1(String speedM1) {
        SpeedM1 = speedM1;
    }

    public String getSPeedM2() {
        return SPeedM2;
    }

    public void setSPeedM2(String SPeedM2) {
        this.SPeedM2 = SPeedM2;
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

    public t_condata(String bright, String speedM1, String SPeedM2, String time, String times) {
        Bright = bright;
        SpeedM1 = speedM1;
        this.SPeedM2 = SPeedM2;
        this.time = time;
        this.times = times;
    }
}
