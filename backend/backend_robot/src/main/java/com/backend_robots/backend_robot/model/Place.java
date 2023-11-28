package com.backend_robots.backend_robot.model;

public class Place {

    private int x;
    private int y;
    private String  name;

    public Place (int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Place() {
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}