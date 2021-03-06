/**
 * 代理模式
 * 代理就类似于日常的中介 它提供了一个间接地 （安全地）对目标对象的访问方法
 * 常见的如特殊字符的处理 加密等等，基于这个特性 代理模式就可以在不侵入目标方法的前提下
 * 额外地为目标方法扩展新功能
 * 代理分为静态代理以及动态代理
 * 静态代理是指所有的元素在编译期就已经确定 灵活性较差
 * 动态代理是指运行时动态的指定  最著名的例子就是SpringAop了
 */
package com.jdp.structuralPattern.proxy;