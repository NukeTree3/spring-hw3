package com.nuketree3.example.springhw2.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reader")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
}
