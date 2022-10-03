package huse.ddtw.entity;

public class humData {
    private String hum;
    private String time;
    private String times;

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public humData(String hum, String time, String times) {
        this.hum = hum;
        this.time = time;
        this.times = times;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public humData(String hum, String time) {
        this.hum = hum;
        this.time = time;
    }

    public humData() {
    }
}
