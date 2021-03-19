package casestudy.module4.service.contract_detail;

import casestudy.module4.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    Page<ContractDetail> findByContract_Id(Integer id, Pageable pageable);

    void save(ContractDetail contractDetail);
}