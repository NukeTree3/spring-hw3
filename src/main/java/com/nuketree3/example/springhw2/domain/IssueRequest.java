package com.nuketree3.example.springhw2.domain;

import lombok.Data;

@Data
public class IssueRequest {
    private final Long id;
    private final Long bookId;
    private final Long readerId;
}
