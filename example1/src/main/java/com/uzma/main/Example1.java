package com.uzma.main;

import com.uzma.beans.Vehicle;
import com.uzma.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
    public static void main(String[] args) {
        // Vehicle Object Created Strictly Inside Heap
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Ferrari");
        System.out.println("vehicle from heap memory : " +vehicle.getName() );

        // Initializing IOC Container
        // we have to mention the class information, where the configurations are defined
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // While calling getBean() method pass the data type of Spring Bean
        Vehicle vehicle1 =  context.getBean(Vehicle.class);
        System.out.println("Vehicle Name From Spring Context Is : " + vehicle1.getName());

        // Whenever we are using getBean() method with Class Information, we don't have
        // explicitly typecast the object into the corresponding data type.
        // type casting is done internally.
        String hello = context.getBean(String.class);
        System.out.println("String Value From Spring Context Is : " + hello);

        Integer num = context.getBean(Integer.class);
        System.out.println("Integer Value From Spring Context Is : " + num);




    }
}
