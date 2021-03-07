package opa.demo.controllers;

import opa.demo.models.Book;
import opa.demo.services.BookService;
import opa.demo.services.exception.OutOfStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public ModelAndView getHome(@PageableDefault(size = 5) Pageable pageable) {
        Page<Book> books;
        books = bookService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/rent")
    public String rentBook(@RequestParam String rentCode, RedirectAttributes redirectAttributes)  throws OutOfStock {
        Book book = bookService.findByRentCode(rentCode);
        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("messenger", "Thanks for renting from our library!");
        return "redirect:/";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam(required = false) String rentCode, RedirectAttributes redirectAttributes) throws OutOfStock {
        if (bookService.findByRentCode(rentCode) == null){
            return "/book_not_found";
        } else {
            Book book = bookService.findByRentCode(rentCode);
            if (book.getQuantity() >= 10) {
                redirectAttributes.addFlashAttribute("messenger", "This book list is full, please choose another one!");
            } else {
                book.setQuantity(book.getQuantity() + 1);
                bookService.save(book);
                redirectAttributes.addFlashAttribute("messenger", "Thanks for using our library!");
            }
            return "redirect:/";
        }
    }

    @ExceptionHandler(OutOfStock.class)
    public ModelAndView outOfStock(){
        return new ModelAndView("out_of_stock");
    }
}
