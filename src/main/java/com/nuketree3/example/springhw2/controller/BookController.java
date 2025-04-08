package com.nuketree3.example.springhw2.controller;

import com.nuketree3.example.springhw2.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class BookController {

    @Autowired
    private final BookRepository bookRepository;

    @ResponseBody
    @GetMapping("/book/{id}")
    public String bookInfo(@PathVariable int id) {
        return bookRepository.getBook(id);
    }

    @ResponseBody
    @GetMapping("/book/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookRepository.getBook(id);
    }

    @ResponseBody
    @GetMapping("/book")
    public String createBook(@PathVariable int id) {
        return bookRepository.getBook(id);
    }


}
