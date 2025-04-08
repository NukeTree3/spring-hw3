package com.nuketree3.example.springhw2.controller;

import com.nuketree3.example.springhw2.domain.Issue;
import com.nuketree3.example.springhw2.domain.Reader;
import com.nuketree3.example.springhw2.service.IssueService;
import com.nuketree3.example.springhw2.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReaderController {

    private final IssueService issueService;
    private final ReaderService readerService;

    @GetMapping("/reader/{id}")
    public Reader getReader(@PathVariable int id) {
        return readerService.getReader(id);
    }

    @GetMapping("/reader/{id}/issue")
    public List<Issue> getIssues(@PathVariable int id) {
        return issueService.getIssuesByReaderId((long) id);
    }

    @GetMapping("/reader")
    public List<Reader> getReaders() {
        return readerService.getAllReaders();
    }

    @PostMapping("/reader")
    public void createReader(@RequestBody Reader reader) {
        readerService.saveReader(reader);
    }

    @DeleteMapping("/reader/{id}")
    public void deleteReader(@PathVariable int id) {
        readerService.delete(id);
    }

}
