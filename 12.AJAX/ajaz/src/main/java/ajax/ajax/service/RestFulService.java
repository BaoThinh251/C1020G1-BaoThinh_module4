package ajax.ajax.service;

import ajax.ajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RestFulService {
//    List<Blog> findAll();
//    Blog findById(int id);
//    void save(Blog blog);
//    void remove(int id);
    Page<Blog> findAllPage (Pageable pageable);
    Page<Blog> findAllByName (String name, Pageable pageable);
}
