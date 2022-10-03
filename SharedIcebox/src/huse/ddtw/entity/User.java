package huse.ddtw.entity;

public class User {
    int userPrimary;
    String userPhone;
    String userPassword;

    public int getUserPrimary() {
        return userPrimary;
    }

    public void setUserPrimary(int userPrimary) {
        this.userPrimary = userPrimary;
    }



    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User(int userPrimary, String userPhone, String userPassword) {
        this.userPrimary = userPrimary;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }

    public User(String userPhone, String userPassword) {
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }

    public User() {
    }
}
