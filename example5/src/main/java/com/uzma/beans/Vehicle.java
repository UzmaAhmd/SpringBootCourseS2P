package com.uzma.beans;

import org.springframework.stereotype.Component;

@Component // Marks this class as a Spring-managed bean
public class Vehicle {
    private String name="MARUTI SUZUKI";// Default name
    public Vehicle() {
    }

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
