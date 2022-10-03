package huse.ddtw.entity;

public class peopleData {
    private String nameId;
    private String times;

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public peopleData(String nameId, String times) {
        this.nameId = nameId;
        this.times = times;
    }

    public peopleData() {
    }

    public peopleData(String nameId) {
        this.nameId = nameId;
    }
}
