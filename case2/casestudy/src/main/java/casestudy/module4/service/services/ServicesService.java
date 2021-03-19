package casestudy.module4.service.services;


import casestudy.module4.model.services.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicesService {
    Page<Services> findAll(Pageable pageable);
    void save (Services services);
    Services findById (int servicesId);
    void deleteById(int id);
    Page<Services> findAllServicesByName(String name, Pageable pageable);
}
