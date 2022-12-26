package exalt.bankaccount;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import exalt.bankaccount.adapter.out.persistance.AccountRepository;
import exalt.bankaccount.adapter.out.persistance.OperationAdapter;
import exalt.bankaccount.adapter.out.persistance.OperationRepository;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;
import lombok.Builder;

@SpringBootApplication
public class BankaccountApplication {
	@Autowired
	AccountRepository accountRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BankaccountApplication.class, args);
		
	}

	@Bean
	CommandLineRunner start(OperationRepository operationRepository, AccountRepository accountRepository,
			OperationAdapter operationAdapter) {
		return args -> {

			Account account = new Account(1L, "El fou", 20, new ArrayList<>());
			accountRepository.save(account);

			Operation operation = new Operation(null, "Money transfer", 0.0f, null, 12.1f, account);
			operationRepository.save(operation);

		};

	}

}
