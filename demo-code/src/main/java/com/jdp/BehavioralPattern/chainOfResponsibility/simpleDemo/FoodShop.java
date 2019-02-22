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
package com.jdp.BehavioralPattern.chainOfResponsibility.simpleDemo;

/**
 * FoodShop
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/28
 **/
public class FoodShop extends Shop{

    public FoodShop(Shop next) {
        setNext(next);
    }

    @Override
    public void sell(String goodsName) {
        if (goodsName.startsWith("2")){
            System.out.println("get a "+goodsName+" from foodShop");
        }else {
            if (getNext()!=null){
                getNext().sell(goodsName);
            }else {
                System.out.println("没有商店处理该请求");
            }
        }
    }
}
