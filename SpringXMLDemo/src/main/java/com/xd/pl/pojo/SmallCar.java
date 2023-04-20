package com.xd.pl.pojo;

public class SmallCar implements Car{
    private String cname;

    private Integer cprice;

    @Override
    public String toString() {
        return "SmallCar{" +
                "cname='" + cname + '\'' +
                ", cprice=" + cprice +
                '}';
    }

    public SmallCar() {
    }

    public SmallCar(String cname, Integer cprice) {
        this.cname = cname;
        this.cprice = cprice;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCprice() {
        return cprice;
    }

    public void setCprice(Integer cprice) {
        this.cprice = cprice;
    }
}
