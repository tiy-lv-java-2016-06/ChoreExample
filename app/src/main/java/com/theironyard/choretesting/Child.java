package com.theironyard.choretesting;

/**
 * Created by jeff on 8/18/16.
 */
public class Child {
    private int id;
    private String name;
    private String username;
    private int childPoint;
    private boolean tokenValid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getChildPoint() {
        return childPoint;
    }

    public void setChildPoint(int childPoint) {
        this.childPoint = childPoint;
    }

    public boolean isTokenValid() {
        return tokenValid;
    }

    public void setTokenValid(boolean tokenValid) {
        this.tokenValid = tokenValid;
    }
}
