package com.uzma.implementation;

import com.uzma.interfaces.Tyre;
import org.springframework.stereotype.Component;

@Component("michelinTyre")
public class MichelinTyre implements Tyre {
    @Override
    public void rotate() {
        System.out.println("Michelin Tyre");
    }
}
