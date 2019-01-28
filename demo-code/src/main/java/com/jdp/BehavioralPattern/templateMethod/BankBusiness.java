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
package com.jdp.BehavioralPattern.templateMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * BankBusiness
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/25
 **/
public abstract class BankBusiness {
    //这里简单演示  不做并发考虑
    private static List<String> noList=new ArrayList<String>();

    public BankBusiness() {
        this.fillList();
    }

    public void doBusiness(){
        getLineNo();
        waite();
        opration();
    }
    public void getLineNo(){
        if (!noList.isEmpty()){
            System.out.println("您的排队码是:"+noList.remove(0));
        }else {
            this.fillList();
            System.out.println("您的排队码是:"+noList.remove(0));
        }
    }
    public void waite(){
        System.out.println("等待......");
    }
    public abstract void opration();

    private void fillList(){
        for (int i = 0; i <1000 ; i++) {
            noList.add("000"+i);
        }
    }
}
