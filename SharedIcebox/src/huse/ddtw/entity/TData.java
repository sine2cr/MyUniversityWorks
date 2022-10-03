package huse.ddtw.entity;

public class TData {

    private String Tin;
    private String Tout;
    private String LXin;
    private String VStatus;

    private String Bright;
    private String SpeedM1;
    private String SPeedM2;

    private String TinDH;
    private String TinDL;
    private String TG;
    private String LXD;
    private String TBegin;
    private String TEnd;

    private String  time;
    private String times;

    public String getTin() {
        return Tin;
    }

    public void setTin(String tin) {
        Tin = tin;
    }

    public String getTout() {
        return Tout;
    }

    public void setTout(String tout) {
        Tout = tout;
    }

    public String getLXin() {
        return LXin;
    }

    public void setLXin(String LXin) {
        this.LXin = LXin;
    }

    public String getVStatus() {
        return VStatus;
    }

    public void setVStatus(String VStatus) {
        this.VStatus = VStatus;
    }

    public String getBright() {
        return Bright;
    }

    public void setBright(String bright) {
        Bright = bright;
    }

    public String getSpeedM1() {
        return SpeedM1;
    }

    public void setSpeedM1(String speedM1) {
        SpeedM1 = speedM1;
    }

    public String getSPeedM2() {
        return SPeedM2;
    }

    public void setSPeedM2(String SPeedM2) {
        this.SPeedM2 = SPeedM2;
    }

    public String getTinDH() {
        return TinDH;
    }

    public void setTinDH(String tinDH) {
        TinDH = tinDH;
    }

    public String getTinDL() {
        return TinDL;
    }

    public void setTinDL(String tinDL) {
        TinDL = tinDL;
    }

    public String getTG() {
        return TG;
    }

    public void setTG(String TG) {
        this.TG = TG;
    }

    public String getLXD() {
        return LXD;
    }

    public void setLXD(String LXD) {
        this.LXD = LXD;
    }

    public String getTBegin() {
        return TBegin;
    }

    public void setTBegin(String TBegin) {
        this.TBegin = TBegin;
    }

    public String getTEnd() {
        return TEnd;
    }

    public void setTEnd(String TEnd) {
        this.TEnd = TEnd;
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

    public TData() {
    }

    public TData(String tin, String tout, String LXin, String VStatus, String bright, String speedM1, String SPeedM2, String tinDH, String tinDL, String TG, String LXD, String TBegin, String TEnd, String time, String times) {
        Tin = tin;
        Tout = tout;
        this.LXin = LXin;
        this.VStatus = VStatus;
        Bright = bright;
        SpeedM1 = speedM1;
        this.SPeedM2 = SPeedM2;
        TinDH = tinDH;
        TinDL = tinDL;
        this.TG = TG;
        this.LXD = LXD;
        this.TBegin = TBegin;
        this.TEnd = TEnd;
        this.time = time;
        this.times = times;
    }


}
