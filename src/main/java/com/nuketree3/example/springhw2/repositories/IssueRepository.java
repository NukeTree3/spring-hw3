package com.nuketree3.example.springhw2.repositories;

import com.nuketree3.example.springhw2.domain.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    @Query(value = "SELECT * FROM issue WHERE id = :issue_id", nativeQuery = true)
    Issue getIssue(@Param("issue_id") long id);

    @Query(value = "SELECT * FROM issue", nativeQuery = true)
    List<Issue> getIssues();

    @Query(value = "SELECT * FROM issue WHERE reader = :reader_id AND returned IS NULL", nativeQuery = true)
    List<Issue> getIssuesByReaderId(@Param("reader_id") Long readerId);

}
