package com.brunozarth;

public class Points extends Achievement{

    int points;

    public Points(String name, int points) {
        super(name);
        this.points = points;
    }

    public void addPoints(int points){
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
