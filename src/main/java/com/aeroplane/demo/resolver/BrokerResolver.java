package com.aeroplane.demo.resolver;

import com.aeroplane.demo.model.Broker;
import com.aeroplane.demo.model.Contract;
import com.aeroplane.demo.repository.ContractRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class BrokerResolver implements GraphQLResolver<Broker> {
    private ContractRepository contractRepository;

    public BrokerResolver(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract getContract(Broker broker) {
        return contractRepository.getOne(broker.getContract().getId());
    }
}
