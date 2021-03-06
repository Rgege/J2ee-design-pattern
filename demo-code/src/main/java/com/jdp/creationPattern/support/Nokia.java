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
package com.jdp.creationPattern.support;

import com.jdp.creationPattern.support.interf.Mobile;

/**
 * Nokia
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/21
 **/
public class Nokia implements Mobile {
    @Override
    public void useFor() {
        System.out.println("Nokia would be a waste if it didn't have to crack walnuts");
    }
}
