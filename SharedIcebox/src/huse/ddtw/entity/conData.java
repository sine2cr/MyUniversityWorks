package huse.ddtw.entity;

public class conData {

    private String fan1;
    private String fan2;
    private String motor;
    private String led;
    private String time;
    private String times;
    private String fan1_pwm;
    private String fan2_pwm;
    private String led_pwm;

    public String getTimes() {
        return times;
    }

    public conData(String fan1, String fan2, String motor, String led, String time, String times, String fan1_pwm, String fan2_pwm, String led_pwm) {
        this.fan1 = fan1;
        this.fan2 = fan2;
        this.motor = motor;
        this.led = led;
        this.time = time;
        this.times = times;
        this.fan1_pwm = fan1_pwm;
        this.fan2_pwm = fan2_pwm;
        this.led_pwm = led_pwm;
    }

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

    public void setTimes(String times) {
        this.times = times;
    }

    public conData(String fan1, String fan2, String motor, String led, String time, String times) {
        this.fan1 = fan1;
        this.fan2 = fan2;
        this.motor = motor;
        this.led = led;
        this.time = time;
        this.times = times;
    }

    public conData(String fan1, String fan2, String motor, String led, String time) {

        this.fan1 = fan1;
        this.fan2 = fan2;
        this.motor = motor;
        this.led = led;
        this.time = time;
    }

    public String getFan1() {
        return fan1;
    }

    public void setFan1(String fan1) {
        this.fan1 = fan1;
    }

    public conData() {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
