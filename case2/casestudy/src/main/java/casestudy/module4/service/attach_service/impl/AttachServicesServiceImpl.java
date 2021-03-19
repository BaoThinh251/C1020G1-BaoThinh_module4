package casestudy.module4.service.attach_service.impl;

import casestudy.module4.model.contract.AttachService;
import casestudy.module4.repository.contract.AttachServiceRepository;
import casestudy.module4.service.attach_service.AttachServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AttachServicesServiceImpl implements AttachServicesService {

    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public AttachService findById(Integer id) {
        return attachServiceRepository.findById(id).orElse(null) ;
    }

    @Override
    public Page<AttachService> findAll(Pageable pageable) {
        return attachServiceRepository.findAll(pageable);
    }

    @Override
    public AttachService findByName(String name) {
        return attachServiceRepository.findByName(name);
    }
}
