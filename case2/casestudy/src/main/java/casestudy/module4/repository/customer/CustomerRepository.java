package casestudy.module4.repository.customer;

import casestudy.module4.model.customer.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value="select * " +
            "from customer e " +
            "join customer_type p using(customer_type_id) " +
            "where concat(e.customer_name,e.customer_birthday, " +
            "e.customer_id_card, e.customer_phone, e.customer_email, e.customer_address) like %?1%",
            nativeQuery = true)
    Page<Customer> findAllInputTex(String keyword, Pageable pageable);
}
