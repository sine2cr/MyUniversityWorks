package huse.ddtw.entity;

public class lightData {
    private String light;
    private String time;
    private String times;

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public lightData(String light, String time, String times) {
        this.light = light;
        this.time = time;
        this.times = times;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public lightData(String light, String time) {
        this.light = light;
        this.time = time;
    }

    public lightData() {
    }
}
