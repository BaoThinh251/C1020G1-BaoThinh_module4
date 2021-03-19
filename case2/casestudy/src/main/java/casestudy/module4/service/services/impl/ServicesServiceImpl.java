package casestudy.module4.service.services.impl;

import casestudy.module4.model.services.Services;
import casestudy.module4.repository.services.ServicesRepository;
import casestudy.module4.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    ServicesRepository servicesRepository;

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return servicesRepository.findAll(pageable);
    }

    @Override
    public void save(Services services) {
        servicesRepository.save(services);
    }

    @Override
    public Services findById(int servicesId) {
        return servicesRepository.findById(servicesId).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public Page<Services> findAllServicesByName(String name, Pageable pageable) {
        return servicesRepository.findAllByServiceNameContaining(name, pageable);
    }
}
