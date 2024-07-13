package com.nathanflp.criptografia.controller.dtos;


import com.nathanflp.criptografia.domain.Operation;

public record operationResponse(Long id,String userDocument,String creditCardToken,Long value) {

    public static operationResponse toResponse(Operation operation){

        return new operationResponse(
                operation.getId(),
                operation.getEncryptedUserDocument(),
                operation.getEncryptedCreditCardToken(),
                operation.getValue()
        );

    }
}
