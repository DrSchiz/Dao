package com.example.testproj2.models;

import org.springframework.lang.NonNull;

public class School {
    private int Id;
    private String Name;
    private String Adress;

    public School() {

    }

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

    public int getAmountStudents() {
        return AmountStudents;
    }

    public void setAmountStudents(int amountStudents) {
        AmountStudents = amountStudents;
    }

    public School(int id, String name, String adress, int amountStudents) {
        Id = id;
        Name = name;
        Adress = adress;
        AmountStudents = amountStudents;
    }

    private int AmountStudents;
}
