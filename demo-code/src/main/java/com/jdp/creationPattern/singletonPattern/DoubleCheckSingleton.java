package com.jdp.creationPattern.singletonPattern;

/**
 * 双重检查确保线程安全
 */
public class DoubleCheckSingleton {
    /**
     * 如不加volatile 可能会由于jvm重排而引起线程安全问题
     * 这个问题的关键在下面代码第4步处：singleton=new DoubleCheckSingleton();
     * 这行其实做了两个事情：1、调用构造方法，创建了一个实例。2、把这个实例赋值给singleton这个实例变量。
     * 可问题就是，这两步jvm是不保证顺序的。也就是说。可能在调用构造方法之前，singleton已经被设置为非空了。
     *
     * 列如：线程A B同时执行getInstance方法 ：
     * A：获取cpu资源 进入方法 singleton==null -> ture  获取锁资源 进入同步块 双重校验后 执行：singleton=new DoubleCheckSingleton();
     * A：在执行第4步的时候 由于jvm指令重排：在未调用构造方法之前，singleton已经被设置为非空了 放弃CPU资源
     * B：获取cpu资源 执行第一步 此时singleton已经被设置为非空了 直接return
     * A：重新获取cpu资源 调用构造方法 真正实例化对象 return
     * 此时 B 线程获取到的singleton实例就是一个异常了
     */
    private static volatile DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {
    }

    /**
     * Double-Check 既保证了线程安全，也避免了每次获取单例对象都要获取锁资源
     * 提高了效率
     * @return
     */
    public static DoubleCheckSingleton getInstance(){
        if (singleton==null){                           //1
            synchronized (singleton){                   //2
                if (singleton==null){                   //3
                    singleton=new DoubleCheckSingleton();//4 可能重排序
                }
            }
        }
        return singleton;
    }
}
