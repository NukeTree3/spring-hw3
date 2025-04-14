package com.nuketree3.example.springhw2.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bookId")
    private Long bookId;
    @Column(name = "reader")
    private Long readerId;
    @Column(name = "issuedAt")
    private LocalDateTime issuedAt;
    @Column(name = "returned")
    private LocalDateTime returnedAt;

    public Issue(Long bookId, Long readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.issuedAt = LocalDateTime.now();
    }

    public Issue() {

    }
}
