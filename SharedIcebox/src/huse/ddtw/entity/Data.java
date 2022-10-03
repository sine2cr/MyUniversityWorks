package huse.ddtw.entity;

public class Data {
    private String tem;
    private String hum;
    private String light;

    private String fan1;
    private String fan2;
    private String motor;
    private String led;

    private String value1;
    private String value2;
    private String value3;
    private String flag;


    private String fan1_pwm;
    private String fan2_pwm;
    private String led_pwm;

    public String getFan1_pwm() {
        return fan1_pwm;
    }

    public void setFan1_pwm(String fan1_pwm) {
        this.fan1_pwm = fan1_pwm;
    }

    public String getFan2_pwm() {
        return fan2_pwm;
    }

    public void setFan2_pwm(String fan2_pwm) {
        this.fan2_pwm = fan2_pwm;
    }

    public String getLed_pwm() {
        return led_pwm;
    }

    public void setLed_pwm(String led_pwm) {
        this.led_pwm = led_pwm;
    }

    public Data(String tem, String hum, String light, String fan1, String fan2, String motor, String led, String value1, String value2, String value3, String flag, String fan1_pwm, String fan2_pwm, String led_pwm, String time, String times) {
        this.tem = tem;
        this.hum = hum;
        this.light = light;
        this.fan1 = fan1;
        this.fan2 = fan2;
        this.motor = motor;
        this.led = led;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.flag = flag;
        this.fan1_pwm = fan1_pwm;
        this.fan2_pwm = fan2_pwm;
        this.led_pwm = led_pwm;
        this.time = time;
        this.times = times;
    }

    private String time;
    private String times;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTimes() {
        return times;
    }

    public Data(String tem, String hum, String light, String fan1, String fan2, String motor, String led, String value1, String value2, String value3, String flag, String time, String times) {
        this.tem = tem;
        this.hum = hum;
        this.light = light;
        this.fan1 = fan1;
        this.fan2 = fan2;
        this.motor = motor;
        this.led = led;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.flag = flag;
        this.time = time;
        this.times = times;
    }
    public void setTimes(String times) {
        this.times = times;
    }


    public Data() {
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
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
}
