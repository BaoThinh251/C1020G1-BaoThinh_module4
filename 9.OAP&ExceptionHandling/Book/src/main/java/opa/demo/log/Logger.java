package opa.demo.log;

import opa.demo.controllers.BookController;
import opa.demo.models.Book;
import opa.demo.repositorys.BookRepository;
import opa.demo.services.BookService;
import opa.demo.services.exception.OutOfStock;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Method;

@Aspect
public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    Book books;

    @PostMapping("/return")
    public Book getBook(@RequestParam String rentCode) {
        books = bookService.findByRentCode(rentCode);
        return books;
    }

    @AfterReturning("execution(* opa.demo.controllers.BookController.rentBook(*,*))")
    public void afterRenting() {
        LOGGER.info("rent");
    }

    @AfterReturning("execution(* opa.demo.controllers.BookController.returnBook(*,*))")
    public void afterReturning(){
        LOGGER.info("return");
    }

}

