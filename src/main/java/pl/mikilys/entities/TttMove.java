package pl.mikilys.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TttMove {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int player;
    private int x;
    private int y;
    @ManyToOne
    @JoinColumn(name="gameId", referencedColumnName="id")
    private TttGame game;

}