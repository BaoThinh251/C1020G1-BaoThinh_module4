package form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @GetMapping("")
    public String home() {
        return "home";
    }

    @RequestMapping("save")
    public String create(@RequestParam(value = "language", required = false) String language, @RequestParam(value = "page",required = false) String page,
                         @RequestParam(value = "spamsFilter", required = false) boolean spam, @RequestParam(value = "signature",required = false) String signature, Model model){
        model.addAttribute("language", language);
        model.addAttribute("page", page);
        model.addAttribute("spam", spam);
        model.addAttribute("signature", signature);
        return "message";
    }
}
