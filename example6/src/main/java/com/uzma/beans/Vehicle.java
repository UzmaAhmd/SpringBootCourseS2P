package com.uzma.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name;

    public Vehicle() {}

    @PostConstruct
    public void initialize(){
        System.out.println("initialize method called by spring boot");
        this.name="Swift Desire z";
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
