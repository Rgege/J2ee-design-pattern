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
package com.jdp.structuralPattern.decorator;

/**
 * FilterInputStream
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/23
 **/
public class FilterInputStream  extends InputStreamDecorator {

    public FilterInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void read() {
        super.read();
        System.out.println("Filter the stream data");
    }
}
