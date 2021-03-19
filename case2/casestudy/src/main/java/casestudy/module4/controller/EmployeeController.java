package casestudy.module4.controller;

import casestudy.module4.model.customer.Customer;
import casestudy.module4.model.employee.Employee;
import casestudy.module4.service.customer.CustomerService;
import casestudy.module4.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String getMainPage() {
        return "/home";
    }

    @GetMapping("/create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "/employee/create";
    }

    @PostMapping("/save")
    public String saveEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors())
            return "/employee/create";

        Boolean isUnique = employeeService.emailIsUnique(employee.getEmployeeEmail());
        if(!isUnique)
            redirectAttributes.addFlashAttribute("uniqueMessage", "Email is not unique !");
        else {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Successfully created !");
        }

        return "redirect:/employee/list";

    }


    @GetMapping("/list")
    public String employeeList (Model model, Pageable pageable) {
        model.addAttribute("employeeList", employeeService.findAll(pageable));
        return "/employee/list";
    }

    @GetMapping("/{id}/edit")
    public String showEditEmployee(Model model, @PathVariable Integer id){
        model.addAttribute("employee",employeeService.findById(id));
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "/employee/edit";
        }

        employeeService.save(employee);
        model.addAttribute("message", "Successfully updated !");

        return "/employee/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer id){
        employeeService.delete(employeeService.findById(id));

        return "redirect:/employee/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search-data") String input, Model model, Pageable pageable){
        Page<Employee> employees =  employeeService.findAllEmployeeByName(input, pageable);

        if(employees.isEmpty())
            return "notFound";
        else {
            model.addAttribute("listEmployee", employees);
            return "/employee/list";
        }

    }
}
