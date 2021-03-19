package casestudy.module4.service.employee;

import casestudy.module4.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save (Employee employee);
    Employee findById (int id);
    void deleteById(int id);
    Page<Employee> findAllEmployeeByName(String name, Pageable pageable);
    void delete(Employee employee);
    Boolean emailIsUnique(String email);
}
