package com.uzma.main;

import com.uzma.beans.Person;
import com.uzma.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class selfPerson {
    public static void main(String[] args)
    {
        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person=context.getBean(Person.class);
        System.out.println("Student from spring context : " +person.getName());
    }
}
