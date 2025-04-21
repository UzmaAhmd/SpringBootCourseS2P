package com.uzma.main;

import com.uzma.beans.Vehicle;
import com.uzma.config.ProjectConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example8 {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        Supplier<Vehicle> ritzSupplier=new Supplier<Vehicle>() {
            @Override
            public Vehicle get() {
                Vehicle vehicle1=new Vehicle();
                vehicle1.setName("Suzuki Ritz");
                return vehicle1;
            }
        };

        Supplier<Vehicle> tharSupplier=new Supplier<Vehicle>() {
            @Override
            public Vehicle get() {
                Vehicle vehicle1=new Vehicle();
                vehicle1.setName("Thar");
                return vehicle1;
            }
        };

        Random random=new Random();
        int randomNumber= random.nextInt(100,1000);
        if (randomNumber%2==0){
            context.registerBean("ritz",Vehicle.class,ritzSupplier);


        }
        else {
            context.registerBean("thar",Vehicle.class,tharSupplier);

        }

        try {
            Vehicle myRitz=context.getBean("ritz", Vehicle.class);
            System.out.println("ritz bean from spring context : " +myRitz.getName());

        }
        catch (BeansException e){
            System.out.println("Ritz isn't present in spring context memory");
        }

        try{
            Vehicle myThar=context.getBean("thar", Vehicle.class);
            System.out.println("Thar bean from spring context : " +myThar.getName());
        }
        catch (BeansException e){
            System.out.println("Thar isn't present in spring context memory");
        }

        context.close();
    }
}
