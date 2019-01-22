package com.jdp.structuralPattern.proxy.dynamicProxy;

import com.jdp.structuralPattern.proxy.ProxyFactory;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class TargetTest {
    private Target target;

    /**
     * 获取代理对象
     */
    @Before
    public void getTarget(){
        //生成$Proxy0的class文件
        //下面这一大块 可以简化为3
        //获取动态代理类
//        Class proxyClazz = Proxy.getProxyClass(Target.class.getClassLoader(),Target.class);
//        Target target=null;
//        try {
//            //获得代理类的构造函数，并传入参数类型InvocationHandler.class
//            Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
//            //通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
//            target= (Target) constructor.newInstance(new MyInvocationHandler(new RealTarget()));
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        //3
//        target= (Target) Proxy.newProxyInstance(Target.class.getClassLoader(),new Class[]{Target.class},new MyInvocationHandler<Target>(new RealTarget()));
        ProxyFactory<Target> proxyFactory=new ProxyFactory<Target>(new RealTarget());
        target=proxyFactory.getProxyInstance(true);
        this.target=target;
    }

    @Test
    public void methodA() {
        if (this.target !=null){
            System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
            target.methodA("name&xiaoming");
        }else {
            System.out.println("================获取代理对象失败");
        }
    }

    @Test
    public void methodB() {
        if (this.target !=null){
            target.methodB("name&xiaoming");
        }else {
            System.out.println("================获取代理对象失败");
        }
    }
}