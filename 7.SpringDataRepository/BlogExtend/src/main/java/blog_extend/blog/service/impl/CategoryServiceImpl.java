package blog_extend.blog.service.impl;

import blog_extend.blog.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public Page findBlog() {
        return null;
    }

    @Override
    public Object findById(Integer id) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void remove(Integer id) {

    }
}
