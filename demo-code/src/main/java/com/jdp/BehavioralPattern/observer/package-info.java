/**
 * 观察者模式：
 * 一个观察者模式要弄清以下几个元素：
 * 1、事件源和目标
 * 2、事件监听器和具体观察者
 * 3、事件类
 * 4、事件绑定
 * 5、事件处理
 *
 * 事件监听器和具体观察者开始监听事件源和目标 这叫作事件绑定 ，事件源发生事件（事件类）
 * 由观察者们接收到 观察者们作出相应的反应 这叫事件处理
 * java.util.Observable --统一定义了事件源类 我们只要继承这个类就行  里面包含了
 *  addObserver(new Observer())：添加观察者方法、setChanged()设置内部状态方法 只有状态为true 才会通知观察者、以及notifyObservers(Object args)通知所有观察者方法
 * 和
 * java.util.Observer 观察者接口 里面定义了一个 update(Observable o, Object arg)改编自身状态的方法 也就是具体的事件处理
 *
 */
package com.jdp.BehavioralPattern.observer;