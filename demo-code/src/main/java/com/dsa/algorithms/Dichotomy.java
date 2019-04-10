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
package com.dsa.algorithms;

import java.util.Date;

/**
 * Dichotomy  二分法
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/4/10
 **/
public class Dichotomy {

    /**
     * 二分法查询指定数字 的例子
     *
     * @return
     */
    public static int binarySearch(int num, int[] array) {
//        System.out.println("****************使用二分法查找****************");
        int index = 0; // 检索的时候
        int start = 0;  //用start和end两个索引控制它的查询范围
        int end = array.length - 1;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            index = (start + end) / 2;
            if (array.length - 1 == i) {
                System.out.println("抱歉，没有找到");
            } else if (array[index] < num) {
                start = index;
            } else if (array[index] > num) {
                end = index;
            } else {
                System.out.println("二分法查询:"+array[index] + "找到了，在数组下标为" + index + "的地方,查找了" + count + "次。");
                break;
            }
        }
        return count;
    }

    public static int commonSearch(int num, int[] array) {
        int count = 0;
        int lenght = array.length;
        for (int i = 0; i < lenght; i++) {
            count++;
            if (array[i] == num) {
                System.out.println("普通查询:"+array[i] + "找到了，在数组下标为" + i + "的地方,查找了" + count + "次。");
                break;
            }
        }
        return count;
    }

    public static int[] init(int length) {
        int[] array = new int[length];
//        System.out.println("****************初始化数组****************");
        for (int i = 0; i < length; i++) {
            array[i] = i + 1;
        }
        return array;
    }


    public static void test(int i){
        System.out.println("================================================test :"+i);
        int[] array=init(100000000);
        Date s1 = new Date();
        binarySearch(9999999, array);
        Date e1 = new Date();

        Date s2 = new Date();
        commonSearch(9999999, array);
        Date e2 = new Date();

        long t1=e1.getTime()-s1.getTime();
        long t2=e2.getTime()-s2.getTime();

        System.out.println("普通耗时："+t2+"    =======    二分法耗时： "+t1);
    }
    public static void main(String[] args) {
        int[] array=init(100000000);
//        for (int i = 0; i <50 ; i++) {
//            test(i);
//        }
//        int i=0;
    }
}
