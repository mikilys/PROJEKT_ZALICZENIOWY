package pl.mikilys.core;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mikilys.utilities.TttUtilities;

@Data
public class TttBase {

    private int[][] board;

    public TttBase() {

        this.board = new int[3][3];
        boardStart();

    }


    //Base TTT!
    public void boardStart() {

        TttUtilities.initializeBoard(this.board);

    }

//    //checking winner
//    public boolean checkForWin() {
//
//        return TttUtilities.checkForWin(board);
//
//    }
//
//    //no line winner
//    public int finalCounter(int mark) {
//
//        TttUtilities.finalWinner(board, mark);
//        return mark;
//
//    }
//
//    public boolean isBoardFull() {
//
//        return TttUtilities.isBoardFull(this.board);
//
//    }

    public boolean placeMark(int row, int col, int mark) {

        //rest after div by 3
        int rowMod = row % 3;
        int colMod = col % 3;

        //not over board
        if ((rowMod>=0) && (rowMod<3)) {
            if ((colMod>=0) && (colMod<3)) {
                if (this.board[rowMod][colMod] == -1) {
                    this.board[rowMod][colMod] = mark;
                    return true;
                }
            }
        }
        return false;

    }


}
