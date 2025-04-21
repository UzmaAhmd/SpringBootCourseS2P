package com.uzma.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;

//    @Autowired
    Vehicle vehicle;


    @Autowired
    public Person(Vehicle vehicle){
        this.vehicle=vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

//    @Autowired
    public void setVehicle(Vehicle vehicle) {
        System.out.println("setter method called");
        this.vehicle = vehicle;
    }

    @PostConstruct
    public void initialize(){
     this.name="uzma";
    }

}
