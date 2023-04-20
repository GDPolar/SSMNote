package com.xd.pl.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student extends Minor {
    private Integer sid;

    private String sname;

    private String sgender;

    private Car scar;

    private String[] hobbies;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", scar=" + scar +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", teachers=" + teachers +
                '}';
    }

    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    public Student(Integer sid, String sname, String sgender, Car scar, String[] hobbies, Map<String, Teacher> teachers) {
        this.sid = sid;
        this.sname = sname;
        this.sgender = sgender;
        this.scar = scar;
        this.hobbies = hobbies;
        this.teachers = teachers;
    }

    public void setTeachers(Map<String, Teacher> teachers) {
        this.teachers = teachers;
    }

    private Map<String, Teacher> teachers;


    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public Student() {
    }

    public Car getScar() {
        return scar;
    }

    public void setScar(Car scar) {
        this.scar = scar;
    }


}
