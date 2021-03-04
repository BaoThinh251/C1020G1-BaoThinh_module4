package blog.extend.repository;


import blog.extend.model.Blog;
import blog.extend.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByOrderByDateDesc(Pageable pageable);
    Blog findByNameBlog(String name);
    Iterable<Blog> findAllByCategory(Category category);
}
