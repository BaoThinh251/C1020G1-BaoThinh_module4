package validation.validate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import validation.validate.model.User;
import validation.validate.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/form")
    public ModelAndView validate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("form");
            return modelAndView;
        }
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("result");
        return modelAndView;
    }


}
