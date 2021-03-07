package opa.demo.services.impl;

import opa.demo.models.Book;
import opa.demo.repositorys.BookRepository;
import opa.demo.services.BookService;
import opa.demo.services.exception.OutOfStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findByRentCode(String rentCode) {
        return bookRepository.findByRentCode(rentCode);
    }

    @Override
    public void save(Book book) throws OutOfStock {
        if (book.getQuantity() < 0) {
            book.setQuantity(book.getQuantity());
            throw new OutOfStock("OUT OF STOCK!");
        } else {
            bookRepository.save(book);
        }
    }

}
