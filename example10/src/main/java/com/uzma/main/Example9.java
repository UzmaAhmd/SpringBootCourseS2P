package com.uzma.main;

import com.uzma.beans.Person;
import com.uzma.beans.Vehicle;
import com.uzma.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example9 {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle=context.getBean(Vehicle.class);
        Person person=context.getBean(Person.class);

        System.out.println("Vehicle bean from Spring Context : " +vehicle.getName());
        System.out.println("Perso bean from Spring Context : " +person.getName());
        System.out.println("Person bean having vehicle is : " +person.getVehicle().getName());
        context.close();
    }
}
