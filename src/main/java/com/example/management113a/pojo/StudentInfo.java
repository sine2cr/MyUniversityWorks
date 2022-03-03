package com.example.management113a.pojo;

public class StudentInfo {
    private String sname;
    private String snamber;
    private Integer id;

    public StudentInfo() {

    }
    public StudentInfo(String sname) {
        this.sname = sname;
    }

    public StudentInfo(String sname, String snamber) {
        this.sname = sname;
        this.snamber = snamber;
    }

    public StudentInfo(String sname, String snamber, Integer id) {
        this.sname = sname;
        this.snamber = snamber;
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSnamber() {
        return snamber;
    }

    public void setSnamber(String snamber) {
        this.snamber = snamber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "sname='" + sname + '\'' +
                ", snamber='" + snamber + '\'' +
                ", id=" + id +
                '}';
    }
}
