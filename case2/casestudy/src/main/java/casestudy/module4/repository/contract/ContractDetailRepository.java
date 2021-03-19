package casestudy.module4.repository.contract;

import casestudy.module4.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    Page<ContractDetail> findByContract_Id(Integer id, Pageable pageable);
}
