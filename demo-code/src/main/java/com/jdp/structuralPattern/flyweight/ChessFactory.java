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

import java.util.HashMap;
import java.util.Map;

/**
 * ChessFactory
 *
 * @author xiong rui
 * @version 1.0.0
 * @date 2019/1/25
 **/
public class ChessFactory {

    private  Map<String,ChessPieces> chessMap=null;
    public ChessFactory() {
        this.chessMap=new HashMap<String, ChessPieces>();
        ChessPieces wc=WhiteChess.getInstance();
        ChessPieces bc=BlackChess.getInstance();

        this.chessMap.put("WHITE",wc);
        this.chessMap.put("BLACK",bc);
    }

    public ChessPieces getChess(String chessColor){
        if (chessColor==null || chessColor == "") throw new IllegalArgumentException("chess color must be sure");
        ChessPieces chess=this.chessMap.get(chessColor);
        if (chess==null){
            if (chessColor.trim().equals(ChessPieces.ChessColor.WHITE.name())){
                chess=WhiteChess.getInstance();
                this.chessMap.put("WHITE",chess);
            } else if (chessColor.trim().equals(ChessPieces.ChessColor.BLACK.name())){
                chess=BlackChess.getInstance();
                this.chessMap.put("BLACK",chess);
            }
        }
        return chess;
    }
}
