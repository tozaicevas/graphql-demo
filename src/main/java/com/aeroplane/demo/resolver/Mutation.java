package com.aeroplane.demo.resolver;

import com.aeroplane.demo.model.Broker;
import com.aeroplane.demo.model.BrokerData;
import com.aeroplane.demo.model.Contract;
import com.aeroplane.demo.repository.BrokerRepository;
import com.aeroplane.demo.repository.ContractRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private BrokerRepository brokerRepository;
    private ContractRepository contractRepository;

    public Mutation(BrokerRepository brokerRepository, ContractRepository contractRepository) {
        this.brokerRepository = brokerRepository;
        this.contractRepository = contractRepository;
    }

    public Broker createBroker(BrokerData brokerData) {
        Contract foundContract = contractRepository.getOne(brokerData.getContract());
        Broker broker = Broker.builder()
                .firstName(brokerData.getFirstName())
                .lastName(brokerData.getLastName())
                .contract(foundContract)
                .build();
        return brokerRepository.save(broker);
    }

    public Contract createContract(float interest) {
        Contract contract = new Contract(interest);
        return contractRepository.save(contract);
    }
}
