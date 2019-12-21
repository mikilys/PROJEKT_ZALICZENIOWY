package pl.mikilys.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mikilys.entities.TttGame;
import pl.mikilys.repositories.BaseRepository;

import java.util.Random;

@Controller
public class WelcomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private BaseRepository baseRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String welcome(){

        return "Welcome";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String startTheGame(@RequestParam("Xplayer") String Xplayer, @RequestParam("Oplayer") String Oplayer, Model model) {
        TttGame game = new TttGame();
        game.setXplayer(Xplayer);
        game.setOplayer(Oplayer);

        //game save
        game = baseRepository.save(game);
        game.setBoard();

        //random player start
        Random whoStarts = new Random();
        int activePlayer = whoStarts.nextInt(2);

        model.addAttribute("activePlayer", activePlayer);
        model.addAttribute("game", game);
        return "TheGame";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/winner/{winnerPlayer}")
    public String winnerOfTheGame(@PathVariable("winnerPlayer") int winnerPlayer, Model model) {

        TttGame game = new TttGame();
        String oPlayer = game.getOplayer();
        String xPlayer = game.getXplayer();

        LOGGER.info("winnerPlayer {}", winnerPlayer);

        if (winnerPlayer==0) {
            model.addAttribute("winnerPlayer", oPlayer);
        } else {
            model.addAttribute("winnerPlayer", xPlayer);
        }
        return "Winner";

    }

}
