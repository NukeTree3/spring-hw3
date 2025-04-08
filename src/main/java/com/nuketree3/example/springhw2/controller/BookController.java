package com.nuketree3.example.springhw2.controller;

import com.nuketree3.example.springhw2.domain.Book;
import com.nuketree3.example.springhw2.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping("/book/{id}")
    public Book bookInfo(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/book")
    public void createBook(@RequestBody Book book) {
        log.info("Book created: {}", book);
        if(!bookService.saveBook(book)){
            ResponseEntity.status(409);
        }
    }

    @GetMapping("/book")
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }
}
