package casestudy.module4.repository.contract;

import casestudy.module4.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachServiceRepository extends JpaRepository<AttachService, Integer> {
    AttachService findByName(String name);
}
