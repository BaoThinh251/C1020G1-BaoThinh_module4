package casestudy.module4.service.contract;

import casestudy.module4.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ContractService {
    Page<Contract> findAll (Pageable pageable);

    Contract findById(Integer id);

    void save(Contract contract);

    Page<Contract> findAllByStartDateBeforeAndEndDateAfter(String currentDate, Pageable pageable);

    Page<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(String currentDate, String name, Pageable pageable);


}
