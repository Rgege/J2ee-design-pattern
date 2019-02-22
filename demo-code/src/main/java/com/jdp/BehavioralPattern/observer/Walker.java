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
package com.jdp.BehavioralPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Walker
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/29
 **/
public class Walker implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (Integer.parseInt(arg.toString())==0){
            System.out.println("车行道绿灯 人行道红灯 要等红灯了");
        }else if(Integer.parseInt(arg.toString())==1){
            System.out.println("车行道红灯 人行道绿灯 人可以走了");
        }
    }
}
