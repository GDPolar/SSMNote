package com.xd.pl.pojo;

public class BigCar implements Car {

    private String cname;

    private Integer cprice;

    @Override
    public String toString() {
        return "BigCar{" +
                "cname='" + cname + '\'' +
                ", cprice=" + cprice +
                '}';
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

    public BigCar() {
    }

    public BigCar(String cname, Integer cprice) {
        this.cname = cname;
        this.cprice = cprice;
    }
}
