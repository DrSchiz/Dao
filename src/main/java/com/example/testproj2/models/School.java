package com.example.testproj2.models;

public class School {
    private int Id;
    private String Name;
    private String Adress;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public int getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(int amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }

    public School(int id, String name, String adress, int amountOfChildren) {
        Id = id;
        Name = name;
        Adress = adress;
        this.amountOfChildren = amountOfChildren;
    }

    private int amountOfChildren;
}
