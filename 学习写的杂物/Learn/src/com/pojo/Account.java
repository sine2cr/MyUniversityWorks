package com.pojo;

public class Account {
    private int ID;
    private String Snamber;
    private String Sname;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
        return "Account{" +
                "ID=" + ID +
                ", Snamber='" + Snamber + '\'' +
                ", Sname='" + Sname + '\'' +
                '}';
    }
}
