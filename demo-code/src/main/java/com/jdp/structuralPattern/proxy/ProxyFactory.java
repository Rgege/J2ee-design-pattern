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
package com.jdp.structuralPattern.proxy;

import com.jdp.structuralPattern.proxy.dynamicProxy.MyInvocationHandler;
import com.jdp.structuralPattern.proxy.dynamicProxy.Target;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * ProxyFactory
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/21
 **/
public class ProxyFactory<T> {
    private T t;

    public ProxyFactory(T t) {
        this.t = t;
    }

    /**
     * 是否生成动态生成代理类的.class文件
     *
     * @param creatClassFile
     * @return
     */
    public T getProxyInstance(Boolean creatClassFile) {
        InvocationHandler invocationHandler = new MyInvocationHandler(this.t);
        Class[]interfaces=((MyInvocationHandler) invocationHandler).targetInterfaces();
        T proxyInstance = (T) Proxy.newProxyInstance(((MyInvocationHandler) invocationHandler).targetClassLoader(),
                interfaces,
                invocationHandler);
        //把内存中的.class文件写到系统中
        if (creatClassFile) {
            String className=proxyInstance.getClass().getName();
            System.out.println(className);
            writeProxyClass(className.substring(className.lastIndexOf(".")+1),interfaces);
        }
        return proxyInstance;
    }

    private boolean writeProxyClass(String proxyName,Class<T>[] targetInterfaces){
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, targetInterfaces);
        String path = ProxyFactory.class.getClassLoader().getResource("").getPath()+proxyName+".class";
        System.out.println(path);
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
