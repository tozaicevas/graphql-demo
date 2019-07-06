package com.aeroplane.demo.repository;

import com.aeroplane.demo.model.Broker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrokerRepository extends JpaRepository<Broker, Long> {
}
