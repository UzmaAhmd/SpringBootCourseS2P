package com.uzma.config;

import com.uzma.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Spring @Configuration annotation is a part of spring core framework.
 * Spring Configuration annotation indicates that the class has @Bean definition
 * methods. So Spring container can process the class and generate spring beans to
 * be used in the application.
 */

@Configuration
public class ProjectConfig {



    @Bean
    Vehicle vehicle1(){
        System.out.println(" vehilce1 method called by spring ioc container");
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Bugati");
        return vehicle;
    }


    @Bean
    public String hello() {
        return "Hello, Spring!";
    }

    @Bean
    public Integer number() {
        return 42;
    }
}
