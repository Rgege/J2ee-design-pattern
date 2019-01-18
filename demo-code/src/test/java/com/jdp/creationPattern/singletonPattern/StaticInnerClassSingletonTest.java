package com.jdp.creationPattern.singletonPattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaticInnerClassSingletonTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() {
        StaticInnerClassSingleton singletonA=StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton singletonB=StaticInnerClassSingleton.getInstance();
        boolean b=singletonA==singletonB;
        System.out.println("singletonA == singletonB:"+b);
        System.out.println("singletonA:"+singletonA);
        System.out.println("singletonB:"+singletonB);

    }
}