package casestudy.module4.repository.services;

import casestudy.module4.model.services.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {
    Page<Services> findAllByServiceNameContaining(String name, Pageable pageable);
}
