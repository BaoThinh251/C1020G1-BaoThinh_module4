package webservice.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webservice.restful.model.Blog;

@Repository
public interface RestfulRepository extends JpaRepository<Blog, Integer> {
}
