package com.nathanflp.criptografia.repository;

import com.nathanflp.criptografia.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface operationRepository extends JpaRepository<Operation,Long> {
}
