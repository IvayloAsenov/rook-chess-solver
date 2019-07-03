package com.iasenov.chesssolver.model;

import com.iasenov.chesssolver.exception.InvalidBoardException;

import java.util.HashSet;
import java.util.Set;

public class ChessBoard {

    private char[][] board;
    private int rooksLeft;

    public ChessBoard(String boardString) {
        board = new char[8][8];
        rooksLeft = 8;

        buildBoard(boardString);
    }

    /**
     * Returns the board as a 2D array
     *
     * @return board char[][]
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Returns the number of rooks left to be placed
     *
     * @return num of rooks left
     */
    public int getRooksLeft() {
        return rooksLeft;
    }

    /**
     * Adds a rook to the specified position
     *
     * @param col
     * @param row
     */
    public void placeRook(int col, int row) {
        board[row][col] = 'R';
        rooksLeft--;
    }

    /**
     * Removes a rook from the specified position
     *
     * @param col
     * @param row
     */
    public void removeRook(int col, int row) {
        board[row][col] = '.';
        rooksLeft++;
    }

    /**
     * Prints the board to the console
     */
    public String boardToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            sb.append("[");
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    /**
     * Build a 2-Dimensional array from a string
     *
     * @param {String} boardString
     */
    private void buildBoard(String boardString) {
        boardString = boardString.replaceAll("\\[|\\]| ", "");

        int idx = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (boardString.length() <= idx) throw new InvalidBoardException("Invalid board!");
                else if (boardString.charAt(idx) == '.') {
                    board[i][j] = boardString.charAt(idx);
                } else if (boardString.charAt(idx) == 'R') {
                    board[i][j] = boardString.charAt(idx);
                    rooksLeft--;
                } else throw new InvalidBoardException("Invalid board!");
                idx++;
            }
        }
        if (rooksLeft < 0 || !isBoardValid(board)) throw new InvalidBoardException("Invalid board!");
    }

    /**
     * Verifies if the initial board is valid
     *
     * @param {char[][]} board
     * @return {boolean} T/F
     */
    private static boolean isBoardValid(char[][] board) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    if (!set.contains("row:" + i) && !set.contains("col:" + j)) {
                        set.add("row:" + i);
                        set.add("col:" + j);
                    } else return false;
                }
            }
        }
        return true;
    }
}
