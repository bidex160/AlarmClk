package com.example.slidingtest;

public class Arrayclock {

    int id;
    int hours;
    int min;

    public Arrayclock(int hours, int min) {

        this.hours = hours;
        this.min = min;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
