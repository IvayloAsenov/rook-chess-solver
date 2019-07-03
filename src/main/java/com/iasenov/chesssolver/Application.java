package com.iasenov.chesssolver;

import com.iasenov.chesssolver.exception.InvalidBoardException;
import com.iasenov.chesssolver.model.ChessBoard;
import com.iasenov.chesssolver.service.BoardService;

public class Application {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a board configuration when running the program!");
            return;
        }

        ChessBoard board;

        try {
            board = new ChessBoard(args[0]);
        } catch(InvalidBoardException e) {
            System.out.println("You have entered an invalid board.");
            return;
        }

        System.out.println("-INITIAL BOARD-");
        System.out.println(board.boardToString());
        BoardService.solveBoard(board);
        System.out.println("\n-SOLVED BOARD-");
        System.out.println(board.boardToString());
    }
}
