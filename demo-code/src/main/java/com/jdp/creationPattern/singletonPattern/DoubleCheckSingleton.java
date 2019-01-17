package com.jdp.creationPattern.singletonPattern;

/**
 * 双重检查确保线程安全
 */
public class DoubleCheckSingleton {
    //如不加volatile 可能会由于jvm重排而引起线程安全问题
    private static volatile DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {
    }

    /**
     * Double-Check 既保证了线程安全，也避免了每次获取单例对象都要获取锁资源
     * 提高了效率
     * @return
     */
    public static DoubleCheckSingleton getInstance(){
        if (singleton==null){
            synchronized (singleton){
                if (singleton==null){
                    singleton=new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
