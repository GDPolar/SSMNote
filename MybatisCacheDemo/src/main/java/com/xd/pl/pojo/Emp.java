package com.xd.pl.pojo;

import java.io.Serializable;

public class Emp implements Serializable {
    private Integer empId;

    private String empName;

    private Dept dept;

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp(Integer empId, String empName, Dept dept) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
    }
}
