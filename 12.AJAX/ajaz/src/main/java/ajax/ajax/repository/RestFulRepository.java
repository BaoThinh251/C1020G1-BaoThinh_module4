package ajax.ajax.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ajax.ajax.model.Blog;

@Repository
public interface RestFulRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findAllByName(String name, Pageable pageable);
}
