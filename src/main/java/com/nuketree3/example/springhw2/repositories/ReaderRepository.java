package com.nuketree3.example.springhw2.repositories;

import com.nuketree3.example.springhw2.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    @Query(value = "SELECT * FROM reader", nativeQuery = true)
    List<Reader> getReaders();

    @Query(value = "SELECT * FROM reader WHERE id = :reader_id", nativeQuery = true)
    Reader getReader(@Param("reader_id") long id);

    void deleteById(Long id);
}
