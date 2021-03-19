package casestudy.module4.service.contract.impl;

import casestudy.module4.model.contract.Contract;
import casestudy.module4.repository.contract.ContractRepository;
import casestudy.module4.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> findAllByStartDateBeforeAndEndDateAfter(String currentDate, Pageable pageable) {
        return contractRepository.findAllByStartDateBeforeAndEndDateAfter(currentDate, currentDate, pageable);
    }

    @Override
    public Page<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(String currentDate, String name, Pageable pageable) {
        return contractRepository.findAllByStartDateBeforeAndEndDateAfterAndCustomer_CustomerName(currentDate, currentDate, name, pageable);
    }
}
