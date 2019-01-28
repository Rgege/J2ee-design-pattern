package com.jdp.BehavioralPattern.templateMethod;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankBusinessTest {

    @Test
    public void doBusiness() {
        BankBusiness business1=new DrawMoney();
        business1.doBusiness();
        BankBusiness business2=new Loan();
        business2.doBusiness();
    }
}