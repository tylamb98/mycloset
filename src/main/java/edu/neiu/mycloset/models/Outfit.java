package edu.neiu.mycloset.models;

public class Outfit {
    //Instance variables
    private String top;
    private String bottom;
    private String shoes;

    //Constructors
    public Outfit() {
        this.top = "";
        this.bottom = "";
        this.shoes = "";

    }
    public Outfit(String top, String bottom, String shoes) {
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
    }

    //Getters & Setters
    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }
}
