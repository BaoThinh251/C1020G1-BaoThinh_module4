package module4.casestudy.repository;

import module4.casestudy.model.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {
    Page<Services> findAll(Pageable pageable);
}
