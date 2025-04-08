package com.nuketree3.example.springhw2.repositories;

import com.nuketree3.example.springhw2.domain.Issue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {

    private final List<Issue> issues;

    public IssueRepository() {
        issues = new ArrayList<>();
    }

    public Issue getIssue(int id) {
        return issues.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void deleteIssue(int id) {
        issues.remove(getIssue(id));
    }

    public void saveIssue(Issue issue) {
        issues.add(issue);
    }
}
