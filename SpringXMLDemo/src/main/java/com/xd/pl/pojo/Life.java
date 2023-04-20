package com.xd.pl.pojo;

public class Life {
    private int lid;

    private String lname;

    public Life() {
        System.out.println("step1：通过无参构造实例化");
    }

    public Life(int lid, String lname) {
        this.lid = lid;
        this.lname = lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setLid(int lid) {
        this.lid = lid;
        System.out.println("step2：依赖注入");
    }

    public void initMethod() {
        System.out.println("step3：初始化");
    }

    public void destroyMethod() {
        System.out.println("step4：销毁");
    }

    public int getLid() {
        return lid;
    }


    public String getLname() {
        return lname;
    }


    @Override
    public String toString() {
        return "Life{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                '}';
    }

}
