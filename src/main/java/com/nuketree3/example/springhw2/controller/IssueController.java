package com.nuketree3.example.springhw2.controller;

import com.nuketree3.example.springhw2.domain.Issue;
import com.nuketree3.example.springhw2.domain.IssueRequest;
import com.nuketree3.example.springhw2.service.IssueService;
import io.swagger.v3.oas.annotations.Operation;
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

    @ResponseBody
    @GetMapping("/issue/{id}")
    @Operation(summary = "get issue information", description = "возвращает всю информацию о выданных книгах")
    public Issue getIssue(@PathVariable long id) {
        return issueService.getIssue(id);
    }

    @ResponseBody
    @PostMapping("/issue")
    @Operation(summary = "save issue", description = "добавляет запись о выдаче в бд")
    public ResponseEntity<?> Issue(@RequestBody IssueRequest issueRequest) {
        if(!issueService.saveIssue(new Issue(issueRequest.getBookId(), issueRequest.getReaderId()))){
            return new ResponseEntity<>(HttpStatusCode.valueOf(409));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/issue/{id}")
    @Operation(summary = "close issue", description = "закрывает выдачу по id")
    public void closeIssue(@PathVariable long id) {
        issueService.closeIssue(id);
    }

    @ResponseBody
    @DeleteMapping("/issue/{id}")
    @Operation(summary = "delete issue", description = "удаляет запись о выдаче из бд по id")
    public void deleteIssue(@PathVariable long id) {
        issueService.deleteIssue(id);
    }

    @ResponseBody
    @GetMapping("/issue")
    @Operation(summary = "get issue", description = "возвращает список всех выдачей")
    public List<Issue> getIssues() {
        return issueService.getAllIssues();
    }
}
