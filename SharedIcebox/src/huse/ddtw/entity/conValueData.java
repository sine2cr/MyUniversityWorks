package huse.ddtw.entity;

public class conValueData {
    private String fan1;
    private String fan2;
    private String motor;
    private String led;
    private  String value1;
    private String value2;
    private String value3;
    private String time;
    private String times;

    public String getFan1() {
        return fan1;
    }

    public void setFan1(String fan1) {
        this.fan1 = fan1;
    }

    public String getFan2() {
        return fan2;
    }

    public void setFan2(String fan2) {
        this.fan2 = fan2;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getLed() {
        return led;
    }

    public void setLed(String led) {
        this.led = led;
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

    public conValueData(String fan1, String fan2, String motor, String led, String value1, String value2, String value3, String time, String times) {
        this.fan1 = fan1;
        this.fan2 = fan2;
        this.motor = motor;
        this.led = led;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.time = time;
        this.times = times;
    }

    public conValueData() {
    }
}
