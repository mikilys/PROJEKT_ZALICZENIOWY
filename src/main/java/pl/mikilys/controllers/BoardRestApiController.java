package pl.mikilys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.mikilys.entities.TttBase;
import pl.mikilys.entities.TttMove;
import pl.mikilys.repositories.BaseRepository;
import pl.mikilys.repositories.MoveRepository;

import java.util.List;

import static pl.mikilys.utilities.TttUtilities.*;

@RestController
@RequestMapping("/rest/game")
public class BoardRestApiController {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private MoveRepository moveRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{x}/{y}/{player}/{gameId}")
    public String runTheGame(@PathVariable("x") int x, @PathVariable("y") int y, @PathVariable("player") int player,
                                   @PathVariable("gameId") Long gameId, Model model) {

        //getting game id from base db
        TttBase game = baseRepository.findOne(gameId);

        //saving move to db with game id from base db
        TttMove move = new TttMove();
        move.setGame(game);
        move.setX(x);
        move.setY(y);
        move.setPlayer(player);
        move = moveRepository.save(move);

        //setting board
        int[][] actualBoard = game.getBoard();
        actualBoard[x][y] = player;
        game.setActualBoard(actualBoard);

        //winner checking
        int winnerPlayer;
        if (!isBoardFull(actualBoard)) {
            winnerPlayer = checkForWin(actualBoard);
        } else {
            winnerPlayer = finalWinner(actualBoard);
        }

        //final score
        if (winnerPlayer!=-1) {

            model.addAttribute("winnerPlayer", winnerPlayer);

        } else {

            //player change
            int activePlayer;
            if (player == 1) {
                activePlayer = 0;
            } else {
                activePlayer = 1;
            }

            //setting atribute to paragraph in jsp
            model.addAttribute("activePlayer", activePlayer);
        }

        model.addAttribute("game", game);
        return "TheGame";

    }
//
//    public BoardRestApiController(MoveRepository moveRepository) {
//
//        this.moveRepository = moveRepository;
//
//    }


}
