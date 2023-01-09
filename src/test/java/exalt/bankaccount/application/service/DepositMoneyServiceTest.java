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
import org.springframework.boot.test.mock.mockito.MockBean;

import exalt.bankaccount.adapter.out.persistance.AccountRepository;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.config.BankAccountException;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;

@SpringBootTest
public class DepositMoneyServiceTest {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	DepositMoneyService depositMoneyService;
	@Autowired
	AccountPort accountPort;
	@MockBean
	CreateOperationService createOperationService;

	@AfterEach
	void setUp() {
		accountRepository.deleteAll();
	}

	@Test
	public void GIVEN_amount_WHEN_findById_THEN_return_account_after_withdraw() throws Exception {

		// GIVEN
		Operation operation = Operation.builder().amount(400).balance(100l).date(new Date()).build();
		List<Operation> operations = new ArrayList<>();
		operations.add(operation);
		Account account = Account.builder().balance(500).name("testAccount").operations(operations).build();
		account = accountRepository.save(account);

		// WHEN
		Account resultAccount = depositMoneyService.depositMoney(account.getId(), 100);

		// THEN
		assertThat(resultAccount.getName().equals(account.getName()));
		assertThat(resultAccount.getBalance() == 600);

	}

	@Test
	public void GIVEN_non_existant_account_WHEN_findById_THEN_return_exception() {
		// GIVEN
		BankAccountException thrown = Assertions.assertThrows(BankAccountException.class, () -> {
			accountPort.findAccountById(50L);
		});
		// THEN
		Assertions.assertEquals("Account not found", thrown.getCode().getMessage());
	}

	@Test
	public void GIVEN_ZERO_Amount_WHEN_findById_THEN_return_exception() throws Exception {

		// GIVEN
		BankAccountException thrown = Assertions.assertThrows(BankAccountException.class, () -> {
			Operation operation = Operation.builder().amount(400).balance(100l).date(new Date()).build();
			List<Operation> operations = new ArrayList<>();
			operations.add(operation);
			Account account = Account.builder().balance(500).name("testAccount").operations(operations).build();
			account = accountRepository.save(account);
			// WHEN
			Account resultAccount = depositMoneyService.depositMoney(account.getId(), 0);
		});
		// THEN
		Assertions.assertEquals("Amount is zero", thrown.getCode().getMessage());
	}

}
