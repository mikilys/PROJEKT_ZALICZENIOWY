package pl.mikilys.core;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mikilys.utilities.TttUtilities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class TttMove {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String player;
    private int row;
    private int col;
    private int mark;

    public TttMove() {

    }
}