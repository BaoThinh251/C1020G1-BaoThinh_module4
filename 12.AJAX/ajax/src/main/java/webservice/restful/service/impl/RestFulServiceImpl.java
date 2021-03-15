package webservice.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservice.restful.model.Blog;
import webservice.restful.repository.RestfulRepository;
import webservice.restful.service.RestFulService;

import java.util.List;

@Service
public class RestFulServiceImpl implements RestFulService {
    @Autowired
    RestfulRepository restfulRepository;

    @Override
    public List<Blog> findAll() {
        return restfulRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return restfulRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        restfulRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        restfulRepository.deleteById(id);
    }
}
