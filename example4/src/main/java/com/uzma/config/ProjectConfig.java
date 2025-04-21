package com.uzma.config;

import com.uzma.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class ProjectConfig {

    @Primary
    // whenever a bean with class name as return type is used, primary marked will be fetched
    /*
     * When you have multiple beans of the same kind inside the spring context, you
     * can make one of them primary by using @Primary annotation. Primary bean is the one
     * which Spring will choose if it has multiple options, and you don't specify  a name.
     * In other words, It is the default bean that Spring Context will consider in case of
     * confusion due to multiple beans of same type are present.
     */
    @Bean("bugati")
    Vehicle vehicle1(){
        System.out.println("method called by spring ioc container");
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Bugati");
        return vehicle;
    }

    @Bean("audi")
    Vehicle vehicle2(){
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Audi");
        return vehicle;
    }

    @Bean("ferrari")
    Vehicle vehicle3(){
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Ferrari");
        return vehicle;
    }


}
