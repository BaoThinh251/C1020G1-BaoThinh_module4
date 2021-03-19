package casestudy.module4.service.customer.impl;

import casestudy.module4.model.customer.Customer;
import casestudy.module4.repository.customer.CustomerRepository;
import casestudy.module4.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllInputTex(Pageable pageable, String keyword) {
        return customerRepository.findAllInputTex(keyword, pageable);
    }
}
