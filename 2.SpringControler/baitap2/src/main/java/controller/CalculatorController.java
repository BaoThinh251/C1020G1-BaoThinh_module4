package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @RequestMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("calculate")
    public String calculate(@RequestParam(value = "sign") String sign, @RequestParam(value = "number1") int number1,
                            @RequestParam(value = "number2") int number2, Model model){
        String result;
        if(sign.equalsIgnoreCase("plus")) {
            result = String.valueOf(number1 + number2);
        } else if(sign.equalsIgnoreCase("minus")) {
            result = String.valueOf(number1 - number2);
        } else if(sign.equalsIgnoreCase("time")) {
            result = String.valueOf(number1 * number2);
        } else if(sign.equalsIgnoreCase("divide")) {
           if(number2 > 0) {
               result = String.valueOf(number1/number2);
           } else {
               result = "Can't not divide by 0";
           }
        } else {
            result = "Please input number!";
        }
        model.addAttribute("result", result);
        return "index";
    }

}
