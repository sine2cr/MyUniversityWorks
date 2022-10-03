package huse.ddtw.entity;

public class t_valuedata {
    private String TinDH;
    private String TinDL;
    private String TG;
    private String LXD;
    private String TBegin;
    private String TEnd;
    private String time;
    private String times;

    public t_valuedata() {
    }

    public t_valuedata(String tinDH) {
        TinDH = tinDH;
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

    public t_valuedata(String tinDH, String tinDL, String TG, String LXD, String TBegin, String TEnd, String time, String times) {
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
