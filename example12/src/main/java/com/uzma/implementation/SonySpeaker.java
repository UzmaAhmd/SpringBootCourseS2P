package com.uzma.implementation;

import com.uzma.interfaces.Speaker;
import org.springframework.stereotype.Component;

@Component("sonySpeaker")
public class SonySpeaker implements Speaker {
    @Override
    public void makeSound(){
        System.out.println("Sony Speaker called");
    }
}
