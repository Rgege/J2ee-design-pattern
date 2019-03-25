package com.jdp.structuralPattern.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Before;
import org.junit.Test;


public class CglibProxyDemoIntercepterTest {
    private String classSavePath;
    @Before
    public void befor(){
        ClassLoader classLoader=CglibProxyDemoIntercepterTest.class.getClassLoader();
        String s=classLoader.getResource("").getPath();
        this.classSavePath=s.replace("target/test-classes/","CglibProxyClass").substring(1);
    }

    @Test
    public void testCglib(){
        //代理类class文件存入本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, classSavePath);
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(TargetDemo.class);
        enhancer.setCallback(new CglibProxyDemoIntercepter());
        TargetDemo proxyClass= (TargetDemo) enhancer.create();

        proxyClass.method1();
        proxyClass.method2();
    }

    @Test
    public void test2(){
        ClassLoader classLoader=CglibProxyDemoIntercepterTest.class.getClassLoader();
        String s=classLoader.getResource("").getPath();
        s=s.replace("target/test-classes/","CglibProxyClass").substring(1);
        System.out.println(s);
    }
}