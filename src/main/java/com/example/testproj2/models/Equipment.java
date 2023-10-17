package com.example.testproj2.models;

public class Equipment {
    private int Id;
    private String Name;
    private String Type;
    private int Size;

    public Equipment() {

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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public Equipment(int id, String name, String type, int size) {
        Id = id;
        Name = name;
        Type = type;
        Size = size;
    }
}
