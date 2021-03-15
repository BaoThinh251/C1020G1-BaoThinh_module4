package module4.casestudy.controller;

import module4.casestudy.model.Customer;
import module4.casestudy.service.CustomerService;
import module4.casestudy.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/")
    public String getMainPage() {
        return "/mainpage";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Successfully created !");
        return "redirect:/";
    }

    @GetMapping("/list")
    public String customerList (Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("customerList", customerService.findAll(pageable));
        return "/list";
    }

    @GetMapping("/delete")
    public String customerDelete (@RequestParam int id){
        customerService.deleteById(id);
        return "redirect:/list";
    }


}
