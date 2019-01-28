package com.jdp.structuralPattern.flyweight;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessPiecesTest  {

    @Test
    public void locateChess() {
        ChessFactory factory=new ChessFactory();
        ChessPieces white=factory.getChess(ChessPieces.ChessColor.WHITE.name());
        ChessPieces black=factory.getChess(ChessPieces.ChessColor.BLACK.name());

        System.out.println("开局 白子先走：");
        white.locateChess(new Coordinate(1d,1d));
        black.locateChess(new Coordinate(2d,2d));
    }
}