package module4.casestudy.service.impl;

import module4.casestudy.model.Services;
import module4.casestudy.repository.ServicesRepository;
import module4.casestudy.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    ServicesRepository repository;

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Services service) {
        repository.save(service);
    }

    @Override
    public Services findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
