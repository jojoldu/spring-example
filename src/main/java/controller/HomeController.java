package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jojoldu@gmail.com on 2016-02-06.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
