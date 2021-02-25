package calculate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import calculate.service.CalculateService;

@Controller
public class CalculatorController {
    @Autowired
    CalculateService calculate;


    @RequestMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("calculate")
    public String calculate(@RequestParam(value = "sign") String sign, @RequestParam(value = "number1") int number1,
                            @RequestParam(value = "number2") int number2, Model model){
        String result = calculate.calculate(sign, number1, number2);
        model.addAttribute("result", result);
        return "index";
    }

}
