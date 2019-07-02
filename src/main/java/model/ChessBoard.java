package model;

import exception.InvalidBoardException;

public class ChessBoard {

    private char[][] board;
    private int rooksLeft;

    public ChessBoard(String boardString) {
        board = new char[8][8];
        rooksLeft = 8;

        buildBoard(boardString);
    }

    public char[][] getBoard() {
        return board;
    }

    public int getRooksLeft() {
        return rooksLeft;
    }

    public void placeRook(int col, int row) {
        board[row][col] = 'R';
        rooksLeft--;
    }

    public void removeRook(int col, int row) {
        board[row][col] = '.';
        rooksLeft++;
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
                if (boardString.charAt(idx) == '.') {
                    board[i][j] = boardString.charAt(idx);
                } else if (boardString.charAt(idx) == 'R') {
                    board[i][j] = boardString.charAt(idx);
                    rooksLeft--;
                } else throw new InvalidBoardException("Invalid board!");
                idx++;
            }
        }
        if (!isBoardValid()) throw new InvalidBoardException("Invalid board!");
    }

    private boolean isBoardValid() {
        if (rooksLeft < 0) return false;
        return true;
    }
}
