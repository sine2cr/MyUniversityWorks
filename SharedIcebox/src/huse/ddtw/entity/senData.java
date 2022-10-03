package huse.ddtw.entity;

public class senData {

    private String tem;
    private String hum;
    private String light;
    private String time;
    private String times;

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public senData(String tem, String hum, String light, String time, String times) {
        this.tem = tem;
        this.hum = hum;
        this.light = light;
        this.time = time;
        this.times = times;
    }

    public senData(String tem, String hum, String light, String time) {
        this.tem = tem;
        this.hum = hum;
        this.light = light;
        this.time = time;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public senData() {
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
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
}
