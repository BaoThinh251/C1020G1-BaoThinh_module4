package casestudy.module4.controller;

import casestudy.module4.model.employee.Employee;
import casestudy.module4.model.services.Services;
import casestudy.module4.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesService servicesService;

    @GetMapping("")
    public String getMainPage() {
        return "/home";
    }

    @GetMapping("/create")
    public String createServices(Model model) {
        model.addAttribute("services", new Services());
        return "/services/create";
    }

    @PostMapping("/save")
    public String saveServices(@Validated @ModelAttribute("services") Services services, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            return "/services/create";
        }

        servicesService.save(services);
        redirectAttributes.addFlashAttribute("message", "Successfully created !");

        return "redirect:/services/list";
    }

    @GetMapping("/list")
    public String servicesList (Model model,@PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("servicesList", servicesService.findAll(pageable));
        return "/services/list";
    }

    @GetMapping("/delete")
    public String servicesDelete (@RequestParam int id){
        servicesService.deleteById(id);
        return "redirect:/services/list";
    }

    @GetMapping("/{id}/edit")
    public String showEditServices(Model model, @PathVariable Integer id){
        model.addAttribute("services",servicesService.findById(id));
        return "/services/edit";
    }

    @PostMapping("/edit")
    public String editServices(@Validated @ModelAttribute("service") Services service, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "/services/edit";
        }

        servicesService.save(service);
        model.addAttribute("message", "Successfully updated !");

        return "/services/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search-data") String input, Model model,@PageableDefault(size = 5) Pageable pageable){
        Page<Services> services =  servicesService.findAllServicesByName(input, pageable);

        if(services.isEmpty())
            return "notFound";
        else {
            model.addAttribute("listServices", services);
            return "/services/list";
        }

    }
}
