package com.aeroplane.demo.repository;

import com.aeroplane.demo.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
