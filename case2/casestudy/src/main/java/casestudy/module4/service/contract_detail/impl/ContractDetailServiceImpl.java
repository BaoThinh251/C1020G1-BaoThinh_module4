package casestudy.module4.service.contract_detail.impl;

import casestudy.module4.model.contract.ContractDetail;
import casestudy.module4.repository.contract.ContractDetailRepository;
import casestudy.module4.service.contract_detail.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public Page<ContractDetail> findByContract_Id(Integer id, Pageable pageable) {
        return contractDetailRepository.findByContract_Id(id, pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
