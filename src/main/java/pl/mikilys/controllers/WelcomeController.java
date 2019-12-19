package pl.mikilys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import pl.mikilys.entities.TttBase;

import java.util.Random;

@Controller
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String welcome(){

        return "Welcome";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String startTheGame(@RequestParam("Xplayer") String Xplayer, @RequestParam("Oplayer") String Oplayer, Model model) {
        TttBase game = new TttBase();
        game.setBoard();
        game.setXplayer(Xplayer);
        game.setOplayer(Oplayer);

        //random player start
        Random whoStarts = new Random();
        int activePlayer = whoStarts.nextInt(2);

        model.addAttribute("activePlayer", activePlayer);
        model.addAttribute("game", game);
        return "TheGame";
    }



}