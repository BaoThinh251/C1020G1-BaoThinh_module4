package convert_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConvertController {

    @PostMapping("/ConvertMoney")
    public String afterConvert(){
        return "/result";
    }
}
