package com.nathanflp.criptografia.domain;

import com.nathanflp.criptografia.service.encriptacaoDeDadosService;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_document", nullable = false)
    private String encryptedUserDocument;

    @Column(name = "credit_card", nullable = false)
    private String encryptedCreditCardToken;

    @Column(name = "value")
    private Long value;

    @Transient
    private String rawUserDocument;

    @Transient
    private String rawCreditCardToken;



    public Operation() {
    }

    public Operation(Long id, String encryptedUserDocument, String encryptedCreditCardToken, Long value) {
        this.id = id;
        this.encryptedUserDocument = encryptedUserDocument;
        this.encryptedCreditCardToken = encryptedCreditCardToken;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncryptedUserDocument() {
        return encryptedUserDocument;
    }

    public void setEncryptedUserDocument(String encryptedUserDocument) {
        this.encryptedUserDocument = encryptedUserDocument;
    }

    public String getEncryptedCreditCardToken() {
        return encryptedCreditCardToken;
    }

    public void setEncryptedCreditCardToken(String encryptedCreditCardToken) {
        this.encryptedCreditCardToken = encryptedCreditCardToken;
    }

    public String getRawUserDocument() {
        return rawUserDocument;
    }

    public void setRawUserDocument(String rawUserDocument) {
        this.rawUserDocument = rawUserDocument;
    }

    public String getRawCreditCardToken() {
        return rawCreditCardToken;
    }

    public void setRawCreditCardToken(String rawCreditCardToken) {
        this.rawCreditCardToken = rawCreditCardToken;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(id, operation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @PrePersist
    public void prePersist(){
        this.encryptedUserDocument = encriptacaoDeDadosService.criptografar(rawUserDocument);
        this.encryptedCreditCardToken = encriptacaoDeDadosService.criptografar(rawCreditCardToken);
    }

    @PostLoad
    public void PostLoad(){
        this.rawUserDocument = encriptacaoDeDadosService.descriptografar(encryptedUserDocument);
        this.rawCreditCardToken = encriptacaoDeDadosService.descriptografar(encryptedCreditCardToken);
    }

}
