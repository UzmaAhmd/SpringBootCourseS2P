package com.uzma.main;

import com.uzma.beans.Vehicle;
import com.uzma.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example5 {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
//        Spring scans com.uzma.beans due to @ComponentScan.
//        It detects Vehicle.java because it has @Component.
//        Spring creates an instance of Vehicle and stores it as a singleton bean.

                //use the name used in config package
        //Fetching Vehicle bean from Spring context
        Vehicle vehicle=context.getBean(Vehicle.class);
        //Since Vehicle is marked as @Component, Spring returns the managed instance.
        //The default name "MARUTI SUZUKI" is used.
        System.out.println("Vehicle name from spring context : "  +vehicle.getName());

    }
}
