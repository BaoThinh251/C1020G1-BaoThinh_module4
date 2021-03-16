package module4.casestudy.service;

import module4.casestudy.model.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServicesService {
    Page<Services> findAll(Pageable pageable);
    void save (Services service);
    Services findById (int id);
    void deleteById(int id);
}
