package com.nuketree3.example.springhw2.controller;

import com.nuketree3.example.springhw2.domain.Book;
import com.nuketree3.example.springhw2.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
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

    @ResponseBody
    @GetMapping("/book/{id}")
    @Operation(summary = "get book information", description = "возвращает всю информацию по книге с данным id")
    public Book bookInfo(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @ResponseBody
    @DeleteMapping("/book/{id}")
    @Operation(summary = "delete book", description = "удаляет книгу с данным id")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @ResponseBody
    @PostMapping("/book")
    @Operation(summary = "save book", description = "добавляет книгу в бд")
    public void createBook(@RequestBody Book book) {
        log.info("Book created: {}", book);
        if(!bookService.saveBook(book)){
            ResponseEntity.status(409);
        }
    }

    @ResponseBody
    @GetMapping("/book")
    @Operation(summary = "get books ui information", description = "возвращает страницу со всеми книгами и их информацией")
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }
}
