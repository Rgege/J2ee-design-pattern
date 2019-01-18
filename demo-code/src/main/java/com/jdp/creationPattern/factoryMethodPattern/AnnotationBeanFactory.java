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
package com.jdp.creationPattern.factoryMethodPattern;


import com.jdp.common.annotation.Bean;

/**
 * AnnotationBeanFactory
 * 创建被@Bean注解注释的bean
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/18
 **/
public class AnnotationBeanFactory implements BeanFactory{
    private String scanPackage;

    public AnnotationBeanFactory(String scanPackage) {
        this.scanPackage=scanPackage;
    }

    /**
     * 没做包扫描的功能  这里默认bean全部在com.jdp.creationPattern.support包下
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        Object obj=null;
        try {
            Class<?> clazz=Class.forName(scanPackage+"."+name);
            Bean beanAnnotaion=clazz.getAnnotation(Bean.class);
            if (beanAnnotaion!=null){
                obj=clazz.newInstance();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
