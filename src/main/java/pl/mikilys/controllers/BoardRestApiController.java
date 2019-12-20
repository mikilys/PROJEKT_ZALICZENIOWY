package pl.mikilys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mikilys.entities.TttGame;
import pl.mikilys.entities.TttMove;
import pl.mikilys.repositories.BaseRepository;
import pl.mikilys.repositories.MoveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static pl.mikilys.utilities.TttUtilities.*;

@RestController
@RequestMapping("/rest/game")
public class BoardRestApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private MoveRepository moveRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{x}/{y}/{player}/{gameId}")
    public String runTheGame(@PathVariable("x") int x, @PathVariable("y") int y, @PathVariable("player") int player,
                                   @PathVariable("gameId") Long gameId, Model model) {

        //getting game id from base db
        TttGame game = baseRepository.findOne(gameId);

        //saving move to db with game id from base db
        TttMove move = new TttMove();
        move.setGame(game);
        move.setX(x);
        move.setY(y);
        move.setPlayer(player);
        move = moveRepository.save(move);
        LOGGER.info("move: {}", move);

        //setting board
        int[][] actualBoard = game.getBoard();
        actualBoard[x][y] = player;
        game.setActualBoard(actualBoard);
        LOGGER.info("actualBoard", actualBoard);

        //winner checking
        int winnerPlayer;
        if (!isBoardFull(actualBoard)) {
            winnerPlayer = checkForWin(actualBoard);
        } else {
            winnerPlayer = finalWinner(actualBoard);
        }
        LOGGER.info("winnerPlayer: {}", winnerPlayer);

        //final score
        if (winnerPlayer==1) {
            return "redirect:/winner/1";
        } else if (winnerPlayer==0) {
            return "redirect:/winner/0";
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
