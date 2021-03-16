package module4.casestudy.controller;

import module4.casestudy.model.Customer;
import module4.casestudy.model.Employee;
import module4.casestudy.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "/employee/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Successfully created !");
        return "redirect:/";
    }

    @GetMapping("/list")
    public String employeeList (Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("employeeList", employeeService.findAll(pageable));
        return "/employee/list";
    }

    @GetMapping("/delete")
    public String employeeDelete (@RequestParam int id){
        employeeService.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/{id}/edit")
    public String showEditEmployee(Model model, @PathVariable Integer id){
        model.addAttribute("customer", employeeService.findById(id));
        return "/employee/edit";
    }

    @PostMapping("/employee/edit")
    public String editEmployee(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/list";
    }
}
