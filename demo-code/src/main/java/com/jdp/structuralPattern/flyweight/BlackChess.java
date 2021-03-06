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
 * BlackChess
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/25
 **/
public class BlackChess implements ChessPieces{

    private BlackChess() {
    }

    @Override
    public void locateChess(Coordinate coordinate) {
        System.out.println("轮到黑子下了，本次落子位置为："+coordinate);
    }
    private static class inner{
        static BlackChess chess=new BlackChess();
    }
    public static BlackChess getInstance(){
        return inner.chess;
    }
}
