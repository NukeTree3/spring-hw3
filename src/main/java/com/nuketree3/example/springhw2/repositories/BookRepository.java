package com.nuketree3.example.springhw2.repositories;

import com.nuketree3.example.springhw2.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class BookRepository {

    private final List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
    }

    public Book getBook(int id) {
        log.info("Getting book with id" + id + " : " + books);
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void deleteBook(int id) {
        books.remove(getBook(id));
    }

    public void saveBook(Book book) {
        books.add(book);
    }
}
