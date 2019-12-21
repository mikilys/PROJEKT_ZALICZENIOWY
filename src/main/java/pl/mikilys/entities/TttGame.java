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
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                board[i][j] = -1;
            }
        }

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

}
