package form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @GetMapping("")
    public String home() {
        return "home";
    }

//    @GetMapping("create")
//    public String create(@RequestParam())
}
