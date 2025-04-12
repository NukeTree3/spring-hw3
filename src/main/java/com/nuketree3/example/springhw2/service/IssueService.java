package com.nuketree3.example.springhw2.service;

import com.nuketree3.example.springhw2.domain.Book;
import com.nuketree3.example.springhw2.domain.Issue;
import com.nuketree3.example.springhw2.domain.Reader;
import com.nuketree3.example.springhw2.repositories.BookRepository;
import com.nuketree3.example.springhw2.repositories.IssueRepository;
import com.nuketree3.example.springhw2.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private BookRepository bookRepository;

    @Value("${application.issue.max-allowed-books:1}")
    private int maxAllowedBooks;

    public boolean saveIssue(Issue issue) {
        if(getCloseIssuesByReaderId(issue.getReaderId()).size() < maxAllowedBooks &&
                readerRepository.getReaders().stream().anyMatch(r -> r.getId().equals(issue.getReaderId())) &&
                bookRepository.getBooks().stream().anyMatch(b -> b.getId().equals(issue.getBookId()))) {
            issueRepository.saveIssue(issue);
            return true;
        }
        return false;
    }

    public Issue getIssue(long id) {
        return issueRepository.getIssue(id);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.getIssues();
    }

    public void deleteIssue(long id) {
        issueRepository.deleteIssue(id);
    }

    public List<Issue> getCloseIssuesByReaderId(Long id) {
        return issueRepository.getIssues().stream().filter(i -> Objects.equals(i.getReaderId(), id) && i.getReturnedAt() == null).collect(Collectors.toList());
    }

    public List<Book> getAllReaderNoReturnedBooks(long id){
        List<Book> books = new ArrayList<>();
        for(Issue issue : getCloseIssuesByReaderId(id)) {
            books.add(bookRepository.getBook(issue.getBookId()));
        }
        return books;
    }

    public List<Issue> getIssuesByReaderId(Long id) {
        return issueRepository.getIssues().stream().filter(i -> Objects.equals(i.getReaderId(), id)).collect(Collectors.toList());
    }

    public void closeIssue(long id) {
        issueRepository.getIssue(id).setReturnedAt(LocalDateTime.now());
    }
}
