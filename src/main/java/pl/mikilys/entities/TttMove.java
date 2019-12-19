package pl.mikilys.entities;

import lombok.Data;
import pl.mikilys.entities.TttExtended;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "moves")
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



}