package com.uzma.main;

import com.uzma.beans.Vehicle;
import com.uzma.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example4 {
    public static void main(String[] args) {
            //  Vehicle vehicle=context.getBean("audi", Vehicle.class);
        //System.out.println("VehicleBean from Spring Context: " +vehicle.getName());


        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
        //we can also use only the data type ie, Vehicle.class. this will fetch the bean marked with @primary
        Vehicle vehicle=context.getBean(Vehicle.class);
        System.out.println("Vehicle name from spring context : "  +vehicle.getName());

    }
}
