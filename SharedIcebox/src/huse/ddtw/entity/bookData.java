package huse.ddtw.entity;

public class bookData {
    private String bookID;
    private String bookName;
    private String location;
    private String times;
    private  String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public bookData(String bookID, String bookName, String location, String times, String time) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.location = location;
        this.times = times;
        this.time = time;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public bookData(String bookID, String bookName, String location, String times) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.location = location;
        this.times = times;
    }

    public bookData() {
    }
}
