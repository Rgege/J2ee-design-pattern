package com.jdp.creationPattern.factoryMethodPattern;

/**
 * @Description <P></P>
 * @Author allen
 * @Date 2019/1/18
 * @Version 1.0.0
 **/
public interface BeanFactory {

    Object getBean(String name);
}
