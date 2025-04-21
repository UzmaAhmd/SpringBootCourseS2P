package com.uzma.implementation;

import com.uzma.interfaces.Speaker;

public class BoseSpeaker implements Speaker {
    @Override
    public void makeSound( ){
        System.out.println("Bose Speaker");
    }
}
