package huse.ddtw.entity;

public class t_sendata {
    private String Tin;
    private String Tout;
    private String LXin;
    private String VStatus;
    private String time;
    private String times;

    public t_sendata() {
    }

    public String getTin() {
        return Tin;
    }

    public void setTin(String tin) {
        Tin = tin;
    }

    public String getTout() {
        return Tout;
    }

    public void setTout(String tout) {
        Tout = tout;
    }

    public String getLXin() {
        return LXin;
    }

    public void setLXin(String LXin) {
        this.LXin = LXin;
    }

    public String getVStatus() {
        return VStatus;
    }

    public void setVStatus(String VStatus) {
        this.VStatus = VStatus;
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

    public t_sendata(String tin, String tout, String LXin, String VStatus, String time, String times) {
        Tin = tin;
        Tout = tout;
        this.LXin = LXin;
        this.VStatus = VStatus;
        this.time = time;
        this.times = times;
    }
}
