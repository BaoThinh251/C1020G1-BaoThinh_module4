package casestudy.module4.service.employee.impl;

import casestudy.module4.model.employee.Employee;
import casestudy.module4.repository.employee.EmployeeRepository;
import casestudy.module4.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAllEmployeeByName(String name, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContaining(name, pageable);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Boolean emailIsUnique(String email) {
        List<Employee> employees = employeeRepository.findAll();

        for (Employee employee : employees){
            if(email.equals(employee.getEmployeeEmail())){
                return false;
            }
        }

        return true;
    }


}
