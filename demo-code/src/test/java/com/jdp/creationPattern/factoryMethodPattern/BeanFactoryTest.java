package com.jdp.creationPattern.factoryMethodPattern;

import com.jdp.creationPattern.support.A;
import com.jdp.creationPattern.support.X;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

public class BeanFactoryTest {

    @Test
    public void getBean() {
        BeanFactory annotationBeanFactory=new AnnotationBeanFactory("com.jdp.creationPattern.support");
        BeanFactory xmlBeanFactory=new XmlBeanFactory("/xmls/Bean.xml");

        A a= (A) annotationBeanFactory.getBean("A");
        X x= (X) xmlBeanFactory.getBean("");
        System.out.println(a.getName());
        System.out.println(x.getName());
    }
    @Test
    public void t(){
        String relativelyPath=System.getProperty("user.dir");
        System.out.println(this.getClass().getResource("/xmls/Bean.xml").getPath());
        URL url= XmlBeanFactory.class.getResource("/xmls/Bean.xml");
        System.out.println(url.getFile());
    }
}