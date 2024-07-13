package com.nathanflp.criptografia.controller;


import com.nathanflp.criptografia.controller.dtos.operationRequest;
import com.nathanflp.criptografia.controller.dtos.operationResponse;
import com.nathanflp.criptografia.service.operationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "api/v1/operation")
public class operationController {

    private final operationService service;

    public operationController(operationService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<operationResponse> returnById(@PathVariable Long id){
    return ResponseEntity.ok(service.listById(id));
    }

    @PostMapping
    public ResponseEntity<operationResponse> createOperation(@RequestBody operationRequest request){
        var operation = service.createOperation(request);
        URI URI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/v1/operation/{id}")
                .buildAndExpand(operation.id())
                .toUri();

        return ResponseEntity.created(URI).body(operation);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
