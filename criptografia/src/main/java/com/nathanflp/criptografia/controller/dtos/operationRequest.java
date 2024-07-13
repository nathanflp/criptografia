package com.nathanflp.criptografia.controller.dtos;

public record operationRequest(String userDocument, String creditCardToken, Long value) {
}
