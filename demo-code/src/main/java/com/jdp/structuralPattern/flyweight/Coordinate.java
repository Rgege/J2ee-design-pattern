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
package com.jdp.structuralPattern.flyweight;

/**
 * Coordinate 座标类
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/25
 **/
public class Coordinate {
    private Double y;
    private Double x;

    public Coordinate() {
    }

    public Coordinate(Double y, Double x) {
        this.y = y;
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}
