package org.codeclinic.problems.prb3_NQueen.simulation;

import org.codeclinic.problems.prb3_NQueen.models.NQueen;

public class NQueenSimulator {
    public static void main(String[] args) {
        // new board
        Integer board[][] = {{ 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 1, 0, 0 }};
        NQueen fourQueen = new NQueen(2);
        //fourQueen.setBoard(board);
        fourQueen.solveNQueen();
    }
}
