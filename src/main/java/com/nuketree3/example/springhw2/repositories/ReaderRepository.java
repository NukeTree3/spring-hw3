package com.nuketree3.example.springhw2.repositories;

import com.nuketree3.example.springhw2.domain.Reader;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReaderRepository {

    private final List<Reader> readers;

    public ReaderRepository() {
        readers = new ArrayList<>();
    }

    public Reader getReader(long id) {
        return readers.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void deleteReader(long id) {
        readers.remove(getReader(id));
    }

    public void saveReader(Reader reader) {
        readers.add(reader);
    }
}
