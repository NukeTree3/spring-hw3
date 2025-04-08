package com.nuketree3.example.springhw2.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {
    private final Long id;
    private final Long bookId;
    private final Long readerId;

    private final LocalDateTime issuedAt;
    private LocalDateTime returnedAt;

    public Issue(Long id, Long bookId, Long readerId) {
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.issuedAt = LocalDateTime.now();
        returnedAt = null;
    }
}
