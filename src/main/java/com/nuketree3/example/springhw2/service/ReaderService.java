package com.nuketree3.example.springhw2.service;

import com.nuketree3.example.springhw2.domain.Reader;
import com.nuketree3.example.springhw2.repositories.ReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    public void saveReader(Reader reader) {
        readerRepository.saveReader(reader);
    }

    public Reader getReader(int id) {
        return readerRepository.getReader(id);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.getReaders();
    }

    public void delete(int id){
        readerRepository.deleteReader(id);
    }
}
