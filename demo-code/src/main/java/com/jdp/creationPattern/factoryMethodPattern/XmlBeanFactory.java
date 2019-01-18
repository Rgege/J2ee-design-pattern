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

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * XmlBeanFactory
 * 通过xml文件创建bean
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/18
 **/
public class XmlBeanFactory implements BeanFactory{
    private Document document;

    /**
     * 这里没有对xmL 的路径做处理 所以要传绝对路径
     * @param xmlPath
     */
    public XmlBeanFactory(String xmlPath) {
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        Document doc=null;
        try {
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            URL url= XmlBeanFactory.class.getResource(xmlPath);
            System.out.println(url.getFile());
            doc= builder.parse(new File(url.getFile()));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        this.document=doc;
    }

    @Override
    public Object getBean(String name) {
        if (this.document==null){
            return null;
        }
        Object obj=null;
        try {
            //获取包含类名的文本节点
            NodeList nl = document.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = classNode.getNodeValue();
            //通过类名生成实例对象并将其返回
            Class<?> clazz=Class.forName(cName);
            obj=clazz.newInstance();
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
