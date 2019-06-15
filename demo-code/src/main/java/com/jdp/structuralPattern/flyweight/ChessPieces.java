package com.jdp.structuralPattern.flyweight;

import java.util.Map;

/**
 * @Description <P>抽象享元角色：棋子 棋子的不变因素就是永远有两方 比如五子棋分为黑子和白子</P>
 * @Author allen
 * @Date 2019/1/25
 * @Version 1.0.0
 **/
public interface ChessPieces {
    public enum ChessColor{
        WHITE(),
        BLACK();
    }
    /**
     * 下棋  也就是指定棋子的坐标位置
     * @param coordinate
     */
    void locateChess(Coordinate coordinate);
}
