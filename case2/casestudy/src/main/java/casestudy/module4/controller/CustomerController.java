package casestudy.module4.controller;

import casestudy.module4.model.customer.Customer;
import casestudy.module4.service.customer.CustomerService;
import casestudy.module4.service.customer.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String getMainPage() {
        return "/home";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            return "/customer/create";
        }

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Successfully created !");

        return "redirect:/customer/list";

    }

    @GetMapping("/list")
    public String customerList (Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("customerList", customerService.findAll(pageable));
        return "/customer/list";
    }

    @GetMapping("/delete")
    public String customerDelete (@RequestParam int id){
        customerService.deleteById(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/edit")
    public String showEditCustomer(Model model, @PathVariable Integer id){
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "/customer/edit";
        }

        customerService.save(customer);
        model.addAttribute("message", "Successfully updated !");

        return "/customer/edit";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search-data") Optional<String> keyword, Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customerList;
        if (keyword.isPresent())
            customerList = customerService.findAllInputTex(pageable, keyword.get());
        else
            customerList = customerService.findAll(pageable);

        model.addAttribute("customerList", customerList);

        return "/customer/list";

    }
}
