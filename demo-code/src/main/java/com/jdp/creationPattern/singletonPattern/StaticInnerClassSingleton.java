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
package com.jdp.creationPattern.singletonPattern;

/**
 * StaticInnerClassSingleton
 * 静态内部类
 *
 * 当第一次加载StaticInnerClassSingleton类时并不会初始化singleton,只有在第一次调用Singleton的getInstance方法时才会导致singleton被初始化
 * 因此第一次调用getInstance方法会导致虚拟机加载SingletonHolder类，
 * 这种方式不仅能够确保线程安全，也能保证单例对象的唯一性，同时延迟了单例的实例化。
 * 原因：虚拟机会保证一个类的构造器<clinit>()方法在多线程环境中被正确地加载，同步，如果多个线程同时去初始化一个类，那么只有一个线程去执行这个类的
 * 构造器<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>（）方法完毕。
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/18
 **/
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){
        if (SingletonHolder.singleton !=null){
            throw new IllegalStateException();
        }
    }
    private static class SingletonHolder{//
        private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return SingletonHolder.singleton;
    }
}
