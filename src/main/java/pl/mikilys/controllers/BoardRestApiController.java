package pl.mikilys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
//    public TttBase runTheGame(@PathVariable("gameId") Long gameId,@RequestBody TttMove move, Model model) {
    public TttBase runTheGame(@PathVariable("x") int x, @PathVariable("y") int y, @PathVariable("player") int player,
                              @PathVariable("gameId") Long gameId, Model model) {

        //getting base form db by id
        TttBase game = baseRepository.findById(gameId);

        //saving move to db
        TttMove move = new TttMove();
        move.setGame(game);
        move.setX(x);
        move.setY(y);
        move.setPlayer(player);
        move = moveRepository.save(move);

        List<TttMove> moves  = moveRepository.findAllByGameId(gameId);

        //setting board
        int[][] actualBoard = game.getBoard();
        game.setActualBoard(actualBoard);

        //winner checking
        if (!isBoardFull(actualBoard)) {
            checkForWin(actualBoard);
        } else {
            finalWinner(actualBoard);
        }

        //player change
        player = move.getPlayer();
        if (player == 1) {
            player = 0;
        } else {
            player = 1;
        }

        //setting atribute to paragraph in jsp
        model.addAttribute("activePlayer", player);
        model.addAttribute("game", game);
        return game;

    }

    public BoardRestApiController(MoveRepository moveRepository) {

        this.moveRepository = moveRepository;

    }



}
