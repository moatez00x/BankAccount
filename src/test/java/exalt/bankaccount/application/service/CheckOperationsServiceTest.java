package exalt.bankaccount.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import exalt.bankaccount.adapter.out.persistance.AccountRepository;
import exalt.bankaccount.config.BankAccountException;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;

@SpringBootTest
public class CheckOperationsServiceTest {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CheckOperationsService checkOperationsService;
	
	@AfterEach
	void setUp() {
		accountRepository.deleteAll();
	}

	@Test
	public void GIVEN_Account_WHEN_findById_THEN_return_Operations() throws Exception {

		// GIVEN
		Operation operation = Operation.builder().amount(400).balance(100l).date(new Date()).build();
		List<Operation> operations = new ArrayList<>();
		operations.add(operation);
		Account account = Account.builder().balance(500).name("testAccount").operations(operations).build();
		account = accountRepository.save(account);

		// WHEN
		List<Operation> resultOperations = checkOperationsService.CheckOperations(account.getId());

		// THEN
		assertThat(resultOperations.size()==1);
	}
	
	@Test
	public void GIVEN_non_existant_account_WHEN_findById_THEN_return_exception() {
		// GIVEN
		BankAccountException thrown = Assertions.assertThrows(BankAccountException.class, () -> {
			// WHEN
			List<Operation> resultOperations = checkOperationsService.CheckOperations(50L);
		});
		// THEN
		Assertions.assertEquals("Account not found", thrown.getCode().getMessage());
	}

}
