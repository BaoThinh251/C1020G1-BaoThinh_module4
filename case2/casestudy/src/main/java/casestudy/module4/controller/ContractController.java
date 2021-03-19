package casestudy.module4.controller;

import casestudy.module4.model.contract.AttachService;
import casestudy.module4.model.contract.Contract;
import casestudy.module4.model.contract.ContractDetail;
import casestudy.module4.model.customer.Customer;
import casestudy.module4.model.employee.Employee;
import casestudy.module4.model.services.Services;
import casestudy.module4.service.attach_service.AttachServicesService;
import casestudy.module4.service.contract.ContractService;
import casestudy.module4.service.contract_detail.ContractDetailService;
import casestudy.module4.service.customer.CustomerService;
import casestudy.module4.service.employee.EmployeeService;
import casestudy.module4.service.services.ServicesService;
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


@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachServicesService attachServicesService;

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @ModelAttribute("listService")
    public Page<Services> getListService(@PageableDefault(size = 5) Pageable pageable) {
        return servicesService.findAll(pageable);
    }

    @ModelAttribute("listEmployee")
    public Page<Employee> getListEmployee(@PageableDefault(size = 5) Pageable pageable) {
        return employeeService.findAll(pageable);
    }

    @ModelAttribute("listCustomer")
    public Page<Customer> getListCustomer(@PageableDefault(size = 5) Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @ModelAttribute("listAttachService")
    public Page<AttachService> getListAttachService(Pageable pageable) {
        return attachServicesService.findAll(pageable);
    }

    @ModelAttribute("contractDetail")
    public ContractDetail getContractDetail() {
        return new ContractDetail();
    }

    @GetMapping("/list")
    public String getListContract(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("listContract", contractService.findAll(pageable));

        return "/contract/list";
    }

    @GetMapping("/detail/{id}")
    public String getDetailPage(@PathVariable("id") Integer id, Model model, @PageableDefault(size = 5) Pageable pageable) {
        Contract contract = contractService.findById(id);

        Page<ContractDetail> contractDetails = contractDetailService.findByContract_Id(contract.getId(), pageable);

        model.addAttribute("contract", contract);
        model.addAttribute("listContractDetail", contractDetails);

        return "/contract/detail";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("contract", new Contract());

        return "/contract/create";
    }

    @PostMapping("/save")
    public String createContract(@Validated @ModelAttribute("contract") Contract contract,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 @RequestParam("Massage") Integer masQuantity,
                                 @RequestParam("Car rental") Integer carQuantity,
                                 @RequestParam("Food") Integer foodQuantity,
                                 @RequestParam("Beverage") Integer bevQuantity,
                                 @RequestParam("Karaoke") Integer karaQuantity) {

        if (bindingResult.hasFieldErrors()) {
            return "/contract/create";
        }

        contractService.save(contract);

        if (masQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServicesService.findByName("Massage"), masQuantity));
        if (carQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServicesService.findByName("Car rental"), carQuantity));
        if (foodQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServicesService.findByName("Food"), foodQuantity));
        if (bevQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServicesService.findByName("Beverage"), bevQuantity));
        if (karaQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServicesService.findByName("Karaoke"), karaQuantity));

        redirectAttributes.addFlashAttribute("message", "Successfully created !");

        return "redirect:/contract/create";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id, Model model) {
        Contract contract = contractService.findById(id);

        model.addAttribute("contract", contract);

        return "/contract/edit";
    }

    @GetMapping("/delete")
    public String deleteContract(@RequestParam("id") Integer id){
        contractService.deleteById(contractService.findById(id));

        return "redirect:/contract/list";
    }
}

