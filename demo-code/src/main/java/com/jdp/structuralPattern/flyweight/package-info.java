/**
 * 在面向对象程序设计过程中，有时会面临要创建大量相同或相似对象实例的问题。创建
 * 那么多的对象将会耗费很多的系统资源，它是系统性能提高的一个瓶颈。例如，围棋和五子
 * 棋中的黑白棋子，图像中的坐标点或颜色，局域网中的路由器、交换机和集线器，教室里的
 * 桌子和凳子等。这些对象有很多相似的地方，如果能把它们相同的部分提取出来共享，则能
 * 节省大量的系统资源，这就是享元模式的产生背景。
 *
 * 享元模式: 享元模式的目标 就是减少系统中的对象数量 从而达到减少系统内存消耗 提高其性能的目的
 * 享元模式主要是要区分可共享和不可共享的部分
 * 可共享部分 也就是享元模式中的内部状态 即不会随着环境的改变而改变的部分
 * 不可共享部分 也就是享元模式中的外部状态 指随环境改变而改变的不可以共享的部分
 * 将这两部分区分开来 复用内部状态 动态指定外部状态 再加以组合
 */
package com.jdp.structuralPattern.flyweight;