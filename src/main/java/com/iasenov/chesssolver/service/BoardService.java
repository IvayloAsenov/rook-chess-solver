package com.iasenov.chesssolver.service;

import com.iasenov.chesssolver.model.ChessBoard;

public class BoardService {

    private static final int BOARD_LEN = 8;

    /**
     * Solves the rest of the board by calling the recursive algorithm
     *
     * @param {ChessBoard} board
     */
    public static void solveBoard(ChessBoard board) {
        solve(board);
    }

    /**
     * Backtracking algorithm that tries to place a rook at current position
     * and if it doesn't find a solution it backtracks
     *
     * @param {ChessBoard} board
     * @return {boolean} if current board is solvable
     */
    private static boolean solve(ChessBoard board) {
        if (board.getRooksLeft() == 0) return true;

        for (int i = 0; i < BOARD_LEN; i++) {
            for (int j = 0; j < BOARD_LEN; j++) {
                if (board.getBoard()[i][j] == '.' && isValid(board, i, j)) {
                    board.placeRook(j, i);
                    if (solve(board)) return true;
                    board.removeRook(j, i);
                }
            }
        }
        return true;
    }

    /**
     * Returns true or false depending if current board respects the constraints
     *
     * @param {ChessBoard} board
     * @param {int} row
     * @param {int} col
     * @return {boolean} T/F
     */
    private static boolean isValid(ChessBoard board, int row, int col) {
        for (int i = 0; i < BOARD_LEN; i++) {
            if (board.getBoard()[row][i] == 'R') return false;
            if (board.getBoard()[i][col] == 'R') return false;
        }
        return true;
    }
}

