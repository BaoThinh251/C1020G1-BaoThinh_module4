package opa.demo.services;

import opa.demo.models.Book;
import opa.demo.services.exception.OutOfStock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);
    Book findByRentCode(String rentCode);
    void save(Book book) throws OutOfStock;
}
