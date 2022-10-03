package huse.ddtw.entity;

public class smokeData {
    private String smoke1;
    private String smoke2;
    private String time;
    private String times;

    public smokeData() {
    }

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

    public smokeData(String smoke1, String smoke2, String times) {
        this.smoke1 = smoke1;
        this.smoke2 = smoke2;
        this.times = times;
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

    public smokeData(String smoke1, String smoke2, String time, String times) {
        this.smoke1 = smoke1;
        this.smoke2 = smoke2;
        this.time = time;
        this.times = times;
    }
}
