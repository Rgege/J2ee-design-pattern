package com.jdp.structuralPattern.bridge;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void getCar() {
        Color color=new EnchantingRed();
        Car car=new SportsCar(color);
        System.out.println(car.getCar());
    }
}