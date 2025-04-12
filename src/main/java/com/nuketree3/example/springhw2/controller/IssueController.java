package com.nuketree3.example.springhw2.controller;

import com.nuketree3.example.springhw2.domain.Issue;
import com.nuketree3.example.springhw2.domain.IssueRequest;
import com.nuketree3.example.springhw2.repositories.IssueRepository;
import com.nuketree3.example.springhw2.service.IssueService;
import com.nuketree3.example.springhw2.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class IssueController {

    private final IssueService issueService;
    private final ReaderService readerService;

    @ResponseBody
    @GetMapping("/issue/{id}")
    public Issue getIssue(@PathVariable long id) {
        return issueService.getIssue(id);
    }

    @ResponseBody
    @PostMapping("/issue")
    public ResponseEntity<?> Issue(@RequestBody IssueRequest issueRequest) {
        if(!issueService.saveIssue(new Issue(issueRequest.getId(), issueRequest.getBookId(), issueRequest.getReaderId()))){
            return new ResponseEntity<>(HttpStatusCode.valueOf(409));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/issue/{id}")
    public void closeIssue(@PathVariable long id) {
        issueService.closeIssue(id);
    }

    @ResponseBody
    @DeleteMapping("/issue/{id}")
    public void deleteIssue(@PathVariable long id) {
        issueService.deleteIssue(id);
    }

    @ResponseBody
    @GetMapping("/issue")
    public List<Issue> getIssues() {
        return issueService.getAllIssues();
    }

    @GetMapping("/ui/issue")
    public String showIssue(Model model) {
        model.addAttribute("issues", issueService.getAllIssues());
        return "issues";
    }

    @GetMapping("/ui/reader/{id}")
    public String readerBooks(Model model, @PathVariable long id) {
        model.addAttribute("readerName", readerService.getReader(id).getName());
        model.addAttribute("readerBookHistory", issueService.getAllReaderNoReturnedBooks(id));
        return "reader";
    }
}
