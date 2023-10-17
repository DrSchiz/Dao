package com.example.testproj2.models;

public class Country {
    private int Id;
    private String Name;
    private int amountOfNuclearWeapons;
    private String Leader;

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

    public int getAmountOfNuclearWeapons() {
        return amountOfNuclearWeapons;
    }

    public void setAmountOfNuclearWeapons(int amountOfNuclearWeapons) {
        this.amountOfNuclearWeapons = amountOfNuclearWeapons;
    }

    public String getLeader() {
        return Leader;
    }

    public void setLeader(String leader) {
        Leader = leader;
    }

    public Country(int id, String name, int amountOfNuclearWeapons, String leader) {
        Id = id;
        Name = name;
        this.amountOfNuclearWeapons = amountOfNuclearWeapons;
        Leader = leader;
    }
}
