package com.example.management113a.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;

public class Excel implements Serializable {
    @ExcelProperty(value = "起始时间")
    private String startTime;

    @ExcelProperty("结束时间")
    private String endTime;

    @ExcelProperty("学号")
    private String studentNumber;

    @ExcelProperty("姓名")
    private String studentName;

    public Excel() {
    }

    public Excel(String startTime, String endTime, String studentNumber, String studentName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.studentNumber = studentNumber;
        this.studentName = studentName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Excel{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
