package casestudy.module4.repository.contract;

import casestudy.module4.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByStartDateBeforeAndEndDateAfter(String startDate, String endDate, Pageable pageable);
    void deleteContract (Contract contract);
    Page<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomer_CustomerName(String startDate, String endDate, String name, Pageable pageable);
}
