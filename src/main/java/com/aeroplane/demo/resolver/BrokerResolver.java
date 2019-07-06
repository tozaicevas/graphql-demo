package com.aeroplane.demo.resolver;

import com.aeroplane.demo.model.Broker;
import com.aeroplane.demo.model.Contract;
import com.aeroplane.demo.repository.ContractRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BrokerResolver implements GraphQLResolver<Broker> {
    private ContractRepository contractRepository;

    public BrokerResolver(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract getContract(Broker broker) {
        return contractRepository.findById(broker.getContract().getId()).get();
    }
}
