package casestudy.module4.service.customer;

import casestudy.module4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save (Customer customer);
    Customer findById (int customerId);
    void deleteById(int id);
    Page<Customer> findAllInputTex(Pageable pageable, String keyword);
}
