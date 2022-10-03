package huse.ddtw.entity;

public class smokeBreakData {
    private String smoke1;
    private String smoke2;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public smokeBreakData(String smoke1, String smoke2, String flag, String breakin, String times) {
        this.smoke1 = smoke1;
        this.smoke2 = smoke2;
        this.flag = flag;
        this.breakin = breakin;
        this.times = times;
    }

    private String breakin;
    private String times;

    public String getSmoke1() {
        return smoke1;
    }

    public void setSmoke1(String smoke1) {
        this.smoke1 = smoke1;
    }

    public String getSmoke2() {
        return smoke2;
    }

    public void setSmoke2(String smoke2) {
        this.smoke2 = smoke2;
    }

    public String getBreakin() {
        return breakin;
    }

    public void setBreakin(String breakin) {
        this.breakin = breakin;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public smokeBreakData(String smoke1, String smoke2, String breakin, String times) {
        this.smoke1 = smoke1;
        this.smoke2 = smoke2;
        this.breakin = breakin;
        this.times = times;
    }

    public smokeBreakData() {
    }
}
