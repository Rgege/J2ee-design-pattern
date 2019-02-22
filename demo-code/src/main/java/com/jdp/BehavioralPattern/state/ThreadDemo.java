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
package com.jdp.BehavioralPattern.state;

/**
 * ThreadDemo  --模拟线程的不同状态
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/28
 **/
public  class ThreadDemo {

    private ThreadState state;

    public ThreadDemo() {
        this.setState(new New());
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

    public ThreadState getState() {
        return state;
    }

    public void start(){
        if (this.state!=null && "NEW".equals(this.state.stateName)){

        }
    }
}
