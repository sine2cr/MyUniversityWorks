package huse.ddtw.entity;

public class breakinData {
    private String ifbreakin;
    private String flag;
    private String time;
    private String times;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public breakinData(String ifbreakin, String flag,String times) {
        this.ifbreakin = ifbreakin;
        this.flag = flag;
        this.times = times;
    }

    public String getIfbreakin() {
        return ifbreakin;
    }

    public void setIfbreakin(String ifbreakin) {
        this.ifbreakin = ifbreakin;
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

    public breakinData() {
    }

    public breakinData(String ifbreakin, String times) {
        this.ifbreakin = ifbreakin;
        this.times = times;
    }
}
