package webservice.restful.service;

import webservice.restful.model.Blog;

import java.util.List;

public interface RestFulService {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void remove(int id);
}
