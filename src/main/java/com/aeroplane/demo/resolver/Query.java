package com.aeroplane.demo.resolver;

import com.aeroplane.demo.model.Broker;
import com.aeroplane.demo.model.Contract;
import com.aeroplane.demo.repository.BrokerRepository;
import com.aeroplane.demo.repository.ContractRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
    private BrokerRepository brokerRepository;
    private ContractRepository contractRepository;

    public Query(BrokerRepository brokerRepository, ContractRepository contractRepository) {
        this.brokerRepository = brokerRepository;
        this.contractRepository = contractRepository;
    }

    public Iterable<Broker> findAllBrokers() {
        return brokerRepository.findAll();
    }

    public Broker findBrokerById(long id) {
        return brokerRepository.getOne(id);
    }

    public Iterable<Contract> findAllContracts() {
        return contractRepository.findAll();
    }
}
