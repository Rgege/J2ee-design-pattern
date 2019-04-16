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
package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * CommonThreadPools
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/4/16
 **/
public class CommonThreadPools {

    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        cachedThreadPool();
        fixedThreadPool();
//        singleThreadExecutor();
//        scheduledThreadPoolCycleRun();
//        scheduledThreadPoolDelayedRun();
    }

    /**
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     *
     * 这种类型的线程池特点是：
     *
     * 1、工作线程的创建数量几乎没有限制(其实也有限制的,数目为Interger. MAX_VALUE), 这样可灵活的往线程池中添加线程。
     * 2、如果长时间没有往线程池中提交任务，即如果工作线程空闲了指定的时间(默认为1分钟)，则该工作线程将自动终止。
     * 终止后，如果你又提交了新的任务，则线程池重新创建一个工作线程。
     * 3、在使用CachedThreadPool时，一定要注意控制任务的数量，否则，由于大量线程同时运行，很有会造成系统瘫痪。
     *
     * 重用之前的线程
     * 适合执行许多短期异步任务的程序。
     * 调用 execute() 将重用以前构造的线程
     * 如果没有可用的线程，则创建一个新线程并添加到池中
     * 默认为60s未使用就被终止和移除
     * 长期闲置的池将会不消耗任何资源
     */
    public static void cachedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(index * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("RunTime:["+System.currentTimeMillis()+"] Thread:["+Thread.currentThread().getName()+"] i:["+index+"]");
                }
            });
        }
    }

    /**
     * 创建一个指定工作线程数量的线程池。每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，
     * 则将提交的任务存入到池队列中。
     *
     * FixedThreadPool是一个典型且优秀的线程池，它具有线程池提高程序效率和节省创建线程时所耗的开销的优点。但是，在线程池空闲时，
     * 即线程池中没有可运行任务时，它不会释放工作线程，还会占用一定的系统资源。
     *
     * 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
     * 定长线程池的大小最好根据系统资源进行设置如Runtime.getRuntime().availableProcessors()。
     */
    public static void fixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println("RunTime:["+System.currentTimeMillis()+"] Thread:["+Thread.currentThread().getName()+"] i:["+index+"]");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 创建一个单线程化的Executor，即只创建唯一的工作者线程来执行任务，它只会用唯一的工作线程来执行任务，
     * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。如果这个线程异常结束，会有另一个取代它，保证顺序执行。
     * 单工作线程最大的特点是可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。
     */
    public static void singleThreadExecutor(){
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println("RunTime:["+System.currentTimeMillis()+"] Thread:["+Thread.currentThread().getName()+"] i:["+index+"]");
                        if (index==2){
                            throw new RuntimeException("===========出异常了");
                        }
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行。
     * 延迟多少秒后执行：
     */
    public static void scheduledThreadPoolDelayedRun(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds>>>>>>>RunTime:["+System.currentTimeMillis()+"] Thread:["+Thread.currentThread().getName()+"]");
            }
        }, 3, TimeUnit.SECONDS);
    }

    /**
     * 创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行。
     * 周期性执行：
     */
    public static void scheduledThreadPoolCycleRun(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds>>>>>>>RunTime:["+System.currentTimeMillis()+"] Thread:["+Thread.currentThread().getName()+"]");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
