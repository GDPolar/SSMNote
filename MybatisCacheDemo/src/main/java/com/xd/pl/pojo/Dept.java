package com.xd.pl.pojo;

import java.util.List;

public class Dept {
    private int deptId;

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    private List<Emp> emps;

    public int getDeptId() {
        return deptId;
    }


    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Dept() {
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", emps=" + emps +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Dept(int deptId, List<Emp> emps, String deptName) {
        this.deptId = deptId;
        this.emps = emps;
        this.deptName = deptName;
    }

    private String deptName;

}
