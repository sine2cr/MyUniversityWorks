package software2001.entity;

public class Human {
    private int hid;
    private String username;
    private String password;
    private int age;
    private String sex;
    private int hstate;

    public Human() {
    }

    public Human(int hid, String username, String password, int age, String sex, int hstate) {
        this.hid = hid;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.hstate = hstate;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHstate() {
        return hstate;
    }

    public void setHstate(int hstate) {
        this.hstate = hstate;
    }

    @Override
    public String toString() {
        return "Human{" +
                "hid=" + hid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", hstate=" + hstate +
                '}';
    }
}
