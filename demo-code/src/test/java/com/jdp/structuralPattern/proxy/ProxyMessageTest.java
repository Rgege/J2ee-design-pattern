package com.jdp.structuralPattern.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProxyMessageTest {

    @Test
    public void showMsg() {
        ProxyMessage proxyMessage=new ProxyMessage();
        System.out.println(proxyMessage.showMsg());
    }
}