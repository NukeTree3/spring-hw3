package com.nuketree3.example.springhw2.controller;

import com.nuketree3.example.springhw2.domain.Issue;
import com.nuketree3.example.springhw2.domain.Reader;
import com.nuketree3.example.springhw2.service.IssueService;
import com.nuketree3.example.springhw2.service.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReaderController {

    private final IssueService issueService;
    private final ReaderService readerService;

    @ResponseBody
    @GetMapping("/reader/{id}")
    @Operation(summary = "get reader information", description = "возвращает всю информацию о читателе с данным id")
    public Reader getReader(@PathVariable long id) {
        return readerService.getReader(id);
    }

    @ResponseBody
    @GetMapping("/reader/{id}/issue")
    @Operation(summary = "get reader issue information", description = "возвращает список всех выдачей читателя с данным id")
    public List<Issue> getIssues(@PathVariable long id) {
        return issueService.getIssuesByReaderId( id);
    }

    @ResponseBody
    @GetMapping("/reader")
    @Operation(summary = "get readers information", description = "возвращает список всех читателей")
    public List<Reader> getReaders() {
        return readerService.getAllReaders();
    }

    @ResponseBody
    @PostMapping("/reader")
    @Operation(summary = "save reader", description = "сохраняет читателя в бд")
    public void createReader(@RequestBody Reader reader) {
        readerService.saveReader(reader);
    }

    @ResponseBody
    @DeleteMapping("/reader/{id}")
    @Operation(summary = "delete reader", description = "удаляет читателя с данным id")
    public void deleteReader(@PathVariable long id) {
        readerService.delete(id);
    }
}
