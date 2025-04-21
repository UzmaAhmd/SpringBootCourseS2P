package com.uzma.main;

import com.uzma.beans.Vehicle;
import com.uzma.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3 {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        //specify the name of bean in quotes in order to avoid noUniqueBeanDefinitionException
        //as multiple beans of type Vehicle.class are available
        //     hence,
        //     Vehicle vehicle  =  context.getBean(Vehicle.class);
        //generates exception here

        //we won't be using below line as in ex2 because here we have named the bean already in quotes.
        // Hence wil use that
        //Vehicle vehicle=context.getBean("vehicle1", Vehicle.class);

        Vehicle vehicle=context.getBean("audi", Vehicle.class);
        System.out.println("VehicleBean from Spring Context: " +vehicle.getName());


    }
}
