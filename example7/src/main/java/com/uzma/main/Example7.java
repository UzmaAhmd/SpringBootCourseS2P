package com.uzma.main;

import com.uzma.beans.Vehicle;
import com.uzma.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example7 {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
        //use the name used in config package
        Vehicle vehicle=context.getBean(Vehicle.class);
        System.out.println("Vehicle name from spring context : "  +vehicle.getName());

        context.close();
    }
}
