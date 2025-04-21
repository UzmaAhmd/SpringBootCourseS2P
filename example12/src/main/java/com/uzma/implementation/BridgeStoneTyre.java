package com.uzma.implementation;

import com.uzma.interfaces.Tyre;

public class BridgeStoneTyre implements Tyre {
    @Override
    public void rotate() {
        System.out.println("Bridgestone tyre called");
    }
}
