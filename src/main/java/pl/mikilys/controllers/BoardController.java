package pl.mikilys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mikilys.entities.TttBase;

@Controller
public class BoardController {

    @RequestMapping(method = RequestMethod.GET, value = "/board")
    public String startGame(Model model) {

        TttBase game = new TttBase();
        model.addAttribute("board", game);
        return "TheGame";

    }

}
