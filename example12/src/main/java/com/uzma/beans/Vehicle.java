package com.uzma.beans;

import com.uzma.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name;
    private VehicleServices services;

    //public Vehicle(String name) {
    //    this.name = name;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

@Autowired
    public void setServices(VehicleServices vehicleServices){
        this.services=vehicleServices;
    }
    public void startCar(){
        System.out.println("Starting my car with :");
        this.services.playMusic();
        this.services.startJourney();
    }

}
