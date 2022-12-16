package com.ram.designpatterns;

public abstract class Pizza {
    private String name;

    public Pizza(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();

    public abstract Double cost();

}
