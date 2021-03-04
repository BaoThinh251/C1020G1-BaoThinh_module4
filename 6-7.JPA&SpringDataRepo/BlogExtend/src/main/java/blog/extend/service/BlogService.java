package blog.extend.service;

import blog.extend.model.Blog;
import blog.extend.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Blog findByName(String name);
    Page<Blog> findAllBlog(Pageable pageable);
    void saveBlog(Blog blog);
    Blog findById(Integer id);
    void removeBlog(Integer id);
    Iterable<Blog> findAllByCategory(Category category);
}