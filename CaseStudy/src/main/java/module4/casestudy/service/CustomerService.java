package module4.casestudy.service;

import module4.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save (Customer customer);
    Customer findById (int customerId);
    void deleteById(int id);
}
