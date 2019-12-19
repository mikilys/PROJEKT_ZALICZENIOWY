package pl.mikilys.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TttMove {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String player;
    private int x;
    private int y;
    @ManyToOne
    @JoinColumn(name="gameId", referencedColumnName="id")
    private TttBase game;

    public TttMove() {

        TttBase game = new TttBase();

    }

    public void setBoard(int[][] board) {

        game.setBoard(board);

    }

    public int[][] getBoard() {

        return game.getBoard();

    }



}