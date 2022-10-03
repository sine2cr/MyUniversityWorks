package com.lab.pojo;

public class studentInfo {
     private Integer id;
     private String Snamber;
     private String Sname;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSnamber() {
        return Snamber;
    }

    public void setSnamber(String snamber) {
        Snamber = snamber;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    @Override
    public String toString() {
        return "studentInfo{" +
                "id=" + id +
                ", Snamber='" + Snamber + '\'' +
                ", Sname='" + Sname + '\'' +
                '}';
    }
}
