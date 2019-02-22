package com.jdp.BehavioralPattern.chainOfResponsibility.simpleDemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void sell() {
        Shop c=new CommodityShop(null);
        Shop f=new FoodShop(c);
        Shop a=new ApplianceShop(f);
        a.sell("1_洗衣机");
        a.sell("2_苹果");
        a.sell("3_牙刷");
        a.sell("4_一条狗");
    }
}