package software2001.entity;

public class Manager {
    private Integer mid;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Manager{" +
                "mid=" + mid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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

    public Manager(Integer mid, String username, String password) {
        this.mid = mid;
        this.username = username;
        this.password = password;
    }

    public Manager() {
    }
}
