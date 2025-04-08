package com.nuketree3.example.springhw2.controller;

import com.nuketree3.example.springhw2.domain.Issue;
import com.nuketree3.example.springhw2.domain.IssueRequest;
import com.nuketree3.example.springhw2.service.IssueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping("/issue/{id}")
    public Issue getIssue(@PathVariable int id) {
        return issueService.getIssue(id);
    }

    @PostMapping("/issue")
    public ResponseEntity<?> Issue(@RequestBody IssueRequest issueRequest) {
        if(!issueService.saveIssue(new Issue(issueRequest.getId(), issueRequest.getBookId(), issueRequest.getReaderId()))){
            return new ResponseEntity<>(HttpStatusCode.valueOf(409));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/issue/{id}")
    public void closeIssue(@PathVariable int id) {
        issueService.closeIssue(id);
    }

    @DeleteMapping("/issue/{id}")
    public void deleteIssue(@PathVariable int id) {
        issueService.deleteIssue(id);
    }

    @GetMapping("/issue")
    public List<Issue> getIssues() {
        return issueService.getAllIssues();
    }

}
