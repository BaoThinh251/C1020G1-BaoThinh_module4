package ajax.ajax.service.impl;

import ajax.ajax.repository.RestFulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ajax.ajax.model.Blog;
import ajax.ajax.service.RestFulService;

import java.util.List;

@Service
public class RestFulServiceImpl implements RestFulService {

    @Autowired
    RestFulRepository repository;

//    @Override
//    public List<Blog> findAll() {
//        return repository.findAll();
//    }
//
//    @Override
//    public Blog findById(int id) {
//        return repository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void save(Blog blog) {
//        repository.save(blog);
//    }
//
//    @Override
//    public void remove(int id) {
//        repository.deleteById(id);
//    }

    @Override
    public Page<Blog> findAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByName(String name, Pageable pageable) {
        return repository.findAllByName(name, pageable);
    }


}
