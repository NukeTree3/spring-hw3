package com.nuketree3.example.springhw2.service;

import com.nuketree3.example.springhw2.domain.Book;
import com.nuketree3.example.springhw2.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public boolean saveBook(Book book) {
        bookRepository.save(book);
        return false;
    }

    public Book getBook(long id) {
        return bookRepository.getBook(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getBooks();
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
