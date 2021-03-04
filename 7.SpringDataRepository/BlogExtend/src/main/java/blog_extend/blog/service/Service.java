package blog_extend.blog.service;

import org.springframework.data.domain.Page;

public interface Service<X> {

    Page<X> findBlog();

    X findById(Integer id);

    void save(X x);

    void remove(Integer id);
}
