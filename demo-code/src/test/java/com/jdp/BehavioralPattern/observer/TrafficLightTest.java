package com.jdp.BehavioralPattern.observer;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrafficLightTest {

    @Test
    public void test(){
        TrafficLight light=new TrafficLight();
        light.addObserver(new Walker());
        light.addObserver(new Car());

        light.setLightState(1);

        light.setLightState(0);
    }

}