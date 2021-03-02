package blog.blog.service.impl;

import blog.blog.model.Blog;
import blog.blog.repository.BlogRepository;
import blog.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, Blog blog) {
        Blog oldBlog = blogRepository.findById(id).get();
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setContent(blog.getContent());
        oldBlog.setAuthor(blog.getAuthor());
        blogRepository.save(oldBlog);
    }
}
