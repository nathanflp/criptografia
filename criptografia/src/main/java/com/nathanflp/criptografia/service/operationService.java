package com.nathanflp.criptografia.service;

import com.nathanflp.criptografia.controller.dtos.operationRequest;
import com.nathanflp.criptografia.controller.dtos.operationResponse;
import com.nathanflp.criptografia.domain.Operation;
import com.nathanflp.criptografia.repository.operationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class operationService {

    private final operationRepository repository;

    public operationService(operationRepository repository) {
        this.repository = repository;
    }

    public operationResponse createOperation(operationRequest request){
        var operation = new Operation();
        operation.setRawUserDocument(request.userDocument());
        operation.setRawCreditCardToken(request.creditCardToken());
        operation.setValue(request.value());

        repository.save(operation);

        return operationResponse.toResponse(operation);
    }

    public operationResponse listById(Long id){
        var operations = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return operationResponse.toResponse(operations);

    }

    public void deleteById(Long id){
        var operations = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.deleteById(id);
    }


}

