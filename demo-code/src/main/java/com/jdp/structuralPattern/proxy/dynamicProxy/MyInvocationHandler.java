/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jdp.structuralPattern.proxy.dynamicProxy;

import com.jdp.common.annotation.Aop;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * MyInvocationHandler
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/21
 **/
public class MyInvocationHandler implements InvocationHandler{
    //目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 动态代理 被AOP注解注释的方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getAnnotation(Aop.class) != null) {

            System.out.println("=======================Before target method , do something: if args contains & ,replace it with =");
            int length = args.length;
            Object[] proxyArgs = new Object[length];
            for (int i = 0; i < length; i++) {
                if (args[i].toString().contains("&")) {
                    args[i] = args[i].toString().replace("&", "=");
                }
                proxyArgs[i]=args[i];
            }
        }
        //目标方法执行
        method.invoke(target, args);
        System.out.println("=======================After target method finishied , do something");
        return null;
    }
    private byte[] getProxyByteArry(Object proxy){
        byte[] bytes=null;
        try(ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);){
            oos.writeObject(proxy);
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
    public ClassLoader targetClassLoader(){
        return this.target.getClass().getClassLoader();
    }

    public Class[] targetInterfaces(){
        return this.target.getClass().getInterfaces();
    }
}










