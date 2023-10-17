package com.example.testproj2.models;

public class User {
    private int Id;
    private String Login;
    private String Name;

    public String Email;

    public User() {

    }

    public User(int id, String login, String email, String name) {
        Id = id;
        Login = login;
        Email = email;
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
