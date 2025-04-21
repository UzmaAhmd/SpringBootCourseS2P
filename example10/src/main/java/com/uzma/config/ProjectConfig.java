package com.uzma.config;

import com.uzma.beans.Person;
import com.uzma.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.uzma.beans")

public class ProjectConfig {
    @Bean
    Vehicle vehicle(){
        Vehicle myVehicle=new Vehicle();
        myVehicle.setName("toyota");
        return myVehicle;
    }
}
