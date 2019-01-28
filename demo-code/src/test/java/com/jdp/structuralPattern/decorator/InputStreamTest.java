package com.jdp.structuralPattern.decorator;

import org.junit.Test;

import java.io.BufferedInputStream;

import static org.junit.Assert.*;

public class InputStreamTest{

    @Test
    public void read() {
        System.out.println("======================用缓冲流装饰文件输入流");
        InputStream isBf=new BufferInputStream(new FileInputStream());
        isBf.read();
        System.out.println("======================用过滤流装饰文件输入流");
        InputStream isFf=new FilterInputStream(new FileInputStream());
        isFf.read();

        System.out.println("======================用缓冲流装饰对象输入流");
        InputStream isBo=new BufferInputStream(new ObjectInputStream());
        isBo.read();
        System.out.println("======================用过滤流装饰对象输入流");
        InputStream isFo=new FilterInputStream(new ObjectInputStream());
        isFo.read();

        System.out.println("======================装饰器流可以装饰另一个装饰器流 将数据先过滤 再缓冲");
        InputStream isBff=new BufferInputStream(new FilterInputStream(new FileInputStream()));
        isBff.read();
        System.out.println();
        InputStream isBfo=new BufferInputStream(new FilterInputStream(new ObjectInputStream()));
        isBfo.read();
    }
}