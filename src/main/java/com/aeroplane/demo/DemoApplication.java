package com.aeroplane.demo;

import com.aeroplane.demo.model.Broker;
import com.aeroplane.demo.model.Contract;
import com.aeroplane.demo.repository.BrokerRepository;
import com.aeroplane.demo.repository.ContractRepository;
import com.aeroplane.demo.resolver.BrokerResolver;
import com.aeroplane.demo.resolver.Mutation;
import com.aeroplane.demo.resolver.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmd(BrokerRepository brokerRepository, ContractRepository contractRepository) {
		return args -> {
			Contract contract = new Contract(1.23f);
			contractRepository.save(contract);
			Broker broker = Broker.builder()
					.firstName("Tomas")
					.lastName("Tomaitis")
					.contract(contract)
					.build();
			brokerRepository.save(broker);
		};
	}

	@Bean
	public BrokerResolver brokerResolver(ContractRepository contractRepository) {
		return new BrokerResolver(contractRepository);
	}

	@Bean
	public Mutation mutation(BrokerRepository brokerRepository, ContractRepository contractRepository) {
		return new Mutation(brokerRepository, contractRepository);
	}

	@Bean
	public Query query(BrokerRepository brokerRepository, ContractRepository contractRepository) {
		return new Query(brokerRepository, contractRepository);
	}

}
