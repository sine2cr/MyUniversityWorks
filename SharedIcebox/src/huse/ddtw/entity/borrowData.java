package huse.ddtw.entity;

public class borrowData {
    private String bookId;
    private String nameId;
    private String borrow;
    private String time;
    private String times;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public borrowData(String bookId, String nameId, String borrow, String time, String times) {
        this.bookId = bookId;
        this.nameId = nameId;
        this.borrow = borrow;
        this.time = time;
        this.times = times;
    }

    public borrowData(String bookId, String time) {
        this.bookId = bookId;
        this.time = time;
    }

    public borrowData(String nameId, String time, String times) {
        this.nameId = nameId;
        this.time = time;
        this.times = times;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getBorrow() {
        return borrow;
    }

    public void setBorrow(String borrow) {
        this.borrow = borrow;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public borrowData(String bookId, String nameId, String borrow, String times) {
        this.bookId = bookId;
        this.nameId = nameId;
        this.borrow = borrow;
        this.times = times;
    }

    public borrowData() {
    }
}
