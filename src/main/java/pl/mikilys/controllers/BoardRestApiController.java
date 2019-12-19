package pl.mikilys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.mikilys.entities.TttBase;
import pl.mikilys.repositories.MoveRepository;

@RestController
@RequestMapping("/rest/game")
public class BoardRestApiController {

    @RequestMapping(method = RequestMethod.GET, value = "/{a}/{b}/{player}")
    public TttBase setPlayer(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("player") int player, TttBase game, Model model) {

        int[][] actualBoard = game.getBoard();
        actualBoard[a][b] = player;
        game.setBoard(actualBoard);

        //player change
        if (player == 1) {
            player = 0;
        } else {
            player = 1;
        }

        model.addAttribute("actualPlayer", player);
        return game;

    }

    @Autowired
    private final MoveRepository moveRepository;

    public BoardRestApiController(MoveRepository moveRepository) {

        this.moveRepository = moveRepository;
//        List<TttMove> moves = moveRepository.findAllByGameId(id);

    }



}
