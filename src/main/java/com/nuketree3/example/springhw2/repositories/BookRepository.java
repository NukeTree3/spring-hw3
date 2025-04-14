package com.nuketree3.example.springhw2.repositories;

import com.nuketree3.example.springhw2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book WHERE id = :book_id", nativeQuery = true)
    Book getBook(@Param("book_id") Long bookId);

    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> getBooks();
}
