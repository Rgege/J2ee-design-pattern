/**
 * 原型模式
 * 区别于单列模式 个人理解：单列模式更适用于一些静态的 全局不会改变的用例
 * 例如配置文件  配置文件的属性值在第一次加载完后就不会被改变了  这里适用单例
 * 而原型  更像是copy 如 鞋子 同款鞋子下的每一只鞋子都有其相同处如款式等 和不同处 如size
 * 这时就可以使用原型模式 由一个原型copy出不同的个体 再加以修改特定属性即可
 */
package com.jdp.creationPattern.prototype;