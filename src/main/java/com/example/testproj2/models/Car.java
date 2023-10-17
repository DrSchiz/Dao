package com.example.testproj2.models;

public class Car {
    private int Id;
    private String Model;
    private String Number;
    private boolean isSold;

    public Car() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public Car(int id, String model, String number, boolean isSold) {
        Id = id;
        Model = model;
        Number = number;
        this.isSold = isSold;
    }
}