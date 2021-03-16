package module4.casestudy.service;

import module4.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save (Employee employee);
    Employee findById (int id);
    void deleteById(int id);
}
