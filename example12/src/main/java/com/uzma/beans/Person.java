package com.uzma.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uzma.services.VehicleServices;

@Component
public class Person {
    private String name="Steve";
    private Vehicle vehicle;

    @Autowired
    public  Person(Vehicle vehicle)
    {
        this.vehicle=vehicle;
    }

    /**
     * The @Autowired annotation can be marked on field, constructor, setter method inorder
     * to auto-wire the beans that is `Injecting Beans (Objects)` at runtime by
     * Spring Dependency Injection mechanism.
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        System.out.println("setter method called");
        this.vehicle = vehicle;
    }

}
