package dictionary.controller;

import dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService compare;

    @GetMapping("")
    public String search() {
        return "index";
    }

    @PostMapping("result")
    public String meaning(@RequestParam String keyword, Model model) {
        String result = compare.compare(keyword);
        model.addAttribute("result", result);
        return "result";
    }
}
