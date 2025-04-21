package com.uzma.main;

import com.uzma.beans.Vehicle;
import com.uzma.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        //specify the name of bean in quotes in order to avoid noUniqueBeanDefinitionException
        //as multiple beans of type Vehicle.class are available
        //     hence,
        //     Vehicle vehicle  =  context.getBean(Vehicle.class);
        //generates exception here
        Vehicle vehicle=context.getBean("vehicle2", Vehicle.class);
        System.out.println("VehicleBean from Spring Context: " +vehicle.getName());


    }
}
