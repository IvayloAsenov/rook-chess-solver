package service;

import model.ChessBoard;

public class BoardService {

    private static final int BOARD_LEN = 8;

    public static void solveBoard(ChessBoard board) {
        solve(board);
    }

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

    private static boolean isValid(ChessBoard board, int row, int col) {
        for (int i = 0; i < BOARD_LEN; i++) {
            if (board.getBoard()[row][i] == 'R') return false;
            if (board.getBoard()[i][col] == 'R') return false;
        }
        return true;
    }
}

