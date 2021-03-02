package blog.blog.repository;

import blog.blog.model.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
