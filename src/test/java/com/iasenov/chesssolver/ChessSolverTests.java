package com.iasenov.chesssolver;

import com.iasenov.chesssolver.exception.InvalidBoardException;
import com.iasenov.chesssolver.model.ChessBoard;
import com.iasenov.chesssolver.service.BoardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChessSolverTests {

    @Test
    public void testSolveEmptyHappyBoard() {
        String board = "[. . . . . . . .]" +
                        "[. . . . . . . .]" +
                        "[. . . . . . . .]" +
                        "[. . . . . . . .]" +
                        "[. . . . . . . .]" +
                        "[. . . . . . . .]" +
                        "[. . . . . . . .]" +
                        "[. . . . . . . .]";

        ChessBoard cb = new ChessBoard(board);
        BoardService.solveBoard(cb);

        String solvedBoard = "[R . . . . . . . ]\n" +
                                "[. R . . . . . . ]\n" +
                                "[. . R . . . . . ]\n" +
                                "[. . . R . . . . ]\n" +
                                "[. . . . R . . . ]\n" +
                                "[. . . . . R . . ]\n" +
                                "[. . . . . . R . ]\n" +
                                "[. . . . . . . R ]\n";

        assertEquals(solvedBoard, cb.boardToString());
    }

    @Test
    public void testSolveHappyBoard() {
        String board = "[R . . . . . . .]" +
                "[. . . . . . . .]" +
                "[. . . . . . . .]" +
                "[. . . R . . . .]" +
                "[. . . . . R . .]" +
                "[. . . . . . . .]" +
                "[. . . . . . . .]" +
                "[. . . . . . . R]";

        ChessBoard cb = new ChessBoard(board);
        BoardService.solveBoard(cb);

        String solvedBoard = "[R . . . . . . . ]\n" +
                "[. R . . . . . . ]\n" +
                "[. . R . . . . . ]\n" +
                "[. . . R . . . . ]\n" +
                "[. . . . . R . . ]\n" +
                "[. . . . R . . . ]\n" +
                "[. . . . . . R . ]\n" +
                "[. . . . . . . R ]\n";

        assertEquals(solvedBoard, cb.boardToString());
    }

    @Test
    public void testSadBoard() {
        String sadBoard = "[R . . . . . . .]" +
                "[R . . . . . . .]" +
                "[. . . . . . . .]" +
                "[. . . R . . . .]" +
                "[. . . . . R . .]" +
                "[. . . . . . . .]" +
                "[. . . . . . . .]" +
                "[. . . . . . . R]";

        assertThrows(InvalidBoardException.class, () -> {
            ChessBoard cb = new ChessBoard(sadBoard);
        });
    }

    @Test
    public void testVerySadBoard() {
        String sadBoard = "WHAT A BOARD";

        assertThrows(InvalidBoardException.class, () -> {
            ChessBoard cb = new ChessBoard(sadBoard);
        });
    }
}
