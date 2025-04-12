package com.nuketree3.example.springhw2.controller;

import com.nuketree3.example.springhw2.domain.Issue;
import com.nuketree3.example.springhw2.domain.Reader;
import com.nuketree3.example.springhw2.service.IssueService;
import com.nuketree3.example.springhw2.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ReaderController {

    private final IssueService issueService;
    private final ReaderService readerService;

    @ResponseBody
    @GetMapping("/reader/{id}")
    public Reader getReader(@PathVariable long id) {
        return readerService.getReader(id);
    }

    @ResponseBody
    @GetMapping("/reader/{id}/issue")
    public List<Issue> getIssues(@PathVariable long id) {
        return issueService.getIssuesByReaderId( id);
    }

    @ResponseBody
    @GetMapping("/reader")
    public List<Reader> getReaders() {
        return readerService.getAllReaders();
    }

    @ResponseBody
    @PostMapping("/reader")
    public void createReader(@RequestBody Reader reader) {
        readerService.saveReader(reader);
    }

    @ResponseBody
    @DeleteMapping("/reader/{id}")
    public void deleteReader(@PathVariable long id) {
        readerService.delete(id);
    }

    @GetMapping("/ui/readers")
    public String readers(Model model) {
        model.addAttribute("readers", readerService.getAllReaders());
        return "readers";
    }
}
