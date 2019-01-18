package com.jdp.creationPattern.prototype;

/**
 * @Description <P></P>
 * @Author v-Rui.Xiong@bl.com
 * @Date 2019/1/18
 * @Version 1.0.0
 **/
public interface Shoes extends Cloneable{

    void sell();

    Object clone()throws CloneNotSupportedException;
}
