package com.uzma.config;

import com.uzma.beans.Person;
import com.uzma.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProjectConfig {
    @Bean
    Vehicle vehicle(){
        Vehicle myVehicle=new Vehicle();
        myVehicle.setName("toyota");
        return myVehicle;
    }
    @Bean
    Person person(){
        Person myPerson=new Person();
        myPerson.setName("Uzma");
        myPerson.setVehicle(vehicle());
        return myPerson;
    }

}
