package com.nathanflp.criptografia.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userDocument;

    @Column(nullable = false)
    private String creditCardToken;

    private Long value;
}
