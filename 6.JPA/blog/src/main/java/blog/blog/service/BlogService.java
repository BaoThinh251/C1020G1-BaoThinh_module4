package blog.blog.service;

import blog.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findBlog();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    void update(Integer id, Blog blog);
}
