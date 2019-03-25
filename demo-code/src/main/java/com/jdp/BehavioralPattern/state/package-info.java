/**
 * 状态模式
 * 在软件开发过程中，应用程序中的有些对象可能会根据不同的情况做出不同的行为，我
 * 们把这种对象称为有状态的对象（对应的也有无状态对象），而把影响对象行为的一个或
 * 多个动态变化的属性称为状态。
 * 对于有状态的对象编程 通常是采用if-else模式 if是A状态对象执行A行为 这样的设计有很多弊端
 * 例如在需要新增状态时 必须修改源代码 违背了开闭原则
 *
 * 状态（State）模式的定义：对有状态的对象，把复杂的“判断逻辑”提取到不同的状态
 * 对象中，允许状态对象在其内部状态发生改变时改变其行为。
 */
package com.jdp.BehavioralPattern.state;