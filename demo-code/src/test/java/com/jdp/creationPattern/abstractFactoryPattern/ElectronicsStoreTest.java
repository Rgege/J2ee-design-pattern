package com.jdp.creationPattern.abstractFactoryPattern;

import org.junit.Test;

import static org.junit.Assert.*;

public class ElectronicsStoreTest {

    @Test
    public void buyAComputer() {
        ElectronicsStore storeA=new StoreA();
        ElectronicsStore storeB=new StoreB();
        System.out.println("========================storeA");
        storeA.buyAComputer().useFor();
        System.out.println("========================storeB");
        storeB.buyAComputer().useFor();
    }

    @Test
    public void buyAMobile() {
        ElectronicsStore storeA=new StoreA();
        ElectronicsStore storeB=new StoreB();
        System.out.println("========================storeA");
        storeA.buyAMobile().useFor();
        System.out.println("========================storeB");
        storeB.buyAMobile().useFor();
    }
}