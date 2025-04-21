package com.uzma.main;

import com.uzma.beans.Person;
import com.uzma.beans.Vehicle;
import com.uzma.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example12 {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person=context.getBean(Person.class);

        Vehicle myVehicle=person.getVehicle();
        myVehicle.startCar();
    }
}
