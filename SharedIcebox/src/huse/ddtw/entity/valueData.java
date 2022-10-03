package huse.ddtw.entity;

public class valueData {
    private  String value1;
    private String value2;
    private String value3;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public valueData(String value1, String value2, String value3, String flag, String time, String times) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.flag = flag;
        this.time = time;
        this.times = times;
    }

    private String time;
    private String times;

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public valueData(String value1, String value2, String value3, String time, String times) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.time = time;
        this.times = times;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public valueData(String value1, String value2, String value3, String time) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.time = time;
    }

    public valueData(String value1, String value2, String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public valueData() {
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }
}
