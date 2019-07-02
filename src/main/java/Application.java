import model.ChessBoard;
import service.BoardService;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        String boardString="[R . . . . . . .]" +
                           "[. . . . . R . .]" +
                           "[. . . . . . . .]" +
                           "[. . . . . . . .]" +
                           "[. . . R . . . .]" +
                           "[. . . . . . . .]" +
                           "[. R . . . . . .]" +
                           "[. . . . . R . .]";

        ChessBoard board = new ChessBoard(boardString);
        System.out.println(Arrays.deepToString(board.getBoard()));
        BoardService.solveBoard(board);
        System.out.println(Arrays.deepToString(board.getBoard()));
    }
}
