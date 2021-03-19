package casestudy.module4.service.attach_service;

import casestudy.module4.model.contract.AttachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface AttachServicesService {
    AttachService findById(Integer id);

    Page<AttachService> findAll(Pageable pageable);

    AttachService findByName(String name);

}
