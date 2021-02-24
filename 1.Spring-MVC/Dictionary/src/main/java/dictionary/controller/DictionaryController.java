package dictionary.controller;

import dictionary.model.Dictionary;
import dictionary.service.DictionaryService;
import dictionary.service.DictionaryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class DictionaryController {
    private DictionaryService dictionaryService = new DictionaryServiceImpl();

    @GetMapping("/")
    public String search() {
        return "/index";
    }

    @PostMapping("/result")
    public String meaning(@RequestParam String keyword, Model model) {
        Map<Integer, Dictionary> dictionaries = dictionaryService.findAll();
        for (int i = 1; i < dictionaries.size(); i++) {
            if (keyword.equalsIgnoreCase(dictionaries.get(i).getEn())) {
                model.addAttribute("keyword", keyword);
                model.addAttribute("mean", dictionaries.get(i).getVi());
                return "/mean";
            }
        }
        return "/mean";
    }
}