package pl.mikilys.entities;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class TttGame {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @Transient
    private int[][] board;
    private String Xplayer;
    private String Oplayer;
    @OneToMany(mappedBy="game", fetch = FetchType.EAGER)
    List<TttMove> moves;

    public void setBoard() {

        this.board = new int[3][3];

    }

    public void setActualBoard(int[][] newBoard) {

        this.board = newBoard;

    }

    public int[][] getBoard(){

        int[][] tempBoard = new int[3][3];
        for (TttMove move : moves) {

            tempBoard[move.getX()][move.getY()] = move.getPlayer();

        }
        return tempBoard;
    }

//    public TttGame changeBoard(int a, int b, int player) {
//
//        this.board = board[a][b];
//
//    }

//    //Base TTT!
//    public void boardStart() {
//
//        TttUtilities.initializeBoard(this.board);
//
//    }

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
//    public boolean placeMark(int row, int col, int mark) {
//
//        //rest after div by 3
//        int rowMod = row % 3;
//        int colMod = col % 3;
//
//        //not over board
//        if ((rowMod>=0) && (rowMod<3)) {
//            if ((colMod>=0) && (colMod<3)) {
//                if (this.board[rowMod][colMod] == -1) {
//                    this.board[rowMod][colMod] = mark;
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }


}