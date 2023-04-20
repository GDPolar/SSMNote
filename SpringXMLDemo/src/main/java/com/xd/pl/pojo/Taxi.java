package com.xd.pl.pojo;

import java.util.List;

public class Taxi extends SmallCar {

    private List<Person> passengers;

    public Taxi() {
    }

    public Taxi(String cname, Integer cprice) {
        super(cname, cprice);
    }

    public Taxi(List<Person> passengers) {
        this.passengers = passengers;
    }

    public Taxi(String cname, Integer cprice, List<Person> passengers) {
        super(cname, cprice);
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "passengers=" + passengers +
                '}';
    }

    public List<Person> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Person> passengers) {
        this.passengers = passengers;
    }
}
