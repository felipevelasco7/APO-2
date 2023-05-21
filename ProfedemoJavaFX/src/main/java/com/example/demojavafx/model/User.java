package com.example.demojavafx.model;

// Singleton Class, multiple controlers can access the same unique User intstance
public class User {

    static private User user = new User();
    private String username;
    private String password;

    private User(){
    }

    static public User getInstance(){
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
