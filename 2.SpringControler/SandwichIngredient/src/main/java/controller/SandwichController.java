package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping("")
    public String home() {
        return "index";
    }


    @GetMapping("choose")
    public String save(@RequestParam(value = "ingredient", required = false) String ingredient, Model model) {
        String message;
        if (ingredient == null) {
            message = "Please choose!";
        } else {
            message = ingredient;
        }
        model.addAttribute("message", message);
        return "result";
    }

}
