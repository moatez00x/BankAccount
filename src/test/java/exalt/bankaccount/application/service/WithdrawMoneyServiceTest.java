package exalt.bankaccount.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import exalt.bankaccount.adapter.out.persistance.AccountRepository;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.config.BankAccountException;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;

@SpringBootTest
public class WithdrawMoneyServiceTest {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	WithdrawMoneyService withdrawMoneyService;
	@Autowired
	AccountPort accountPort;
	@MockBean
	CreateOperationService createOperationService;

	@Test
	@Disabled
	public void withdrawMoneySuccess() throws Exception {
		
		// GIVEN

		Operation operation = Operation
		      .builder()
		      .amount(400)
		      .balance(100l)
		      .date(new Date())
		      .build();
		List<Operation> operations = new ArrayList<>();
		operations.add(operation);
		Account account = Account
		      .builder()
		      .balance(500)
		      .name("testAccount")
		      .operations(operations)
		      .build();
		account = accountRepository.save(account);



		Mockito.when(accountPort.findAccountById(Mockito.any())).thenReturn(Optional.of(account));
		Mockito.when(createOperationService.createOperation(Mockito.anyString(),Mockito.anyFloat(),Mockito.anyFloat())).thenReturn(operation);
		Mockito.when(accountPort.save(Mockito.any())).thenReturn(account);
		// WHEN
		Account resultAccount = withdrawMoneyService.withdrawMoney(account.getId(), 100);

		// THEN
		assertThat(resultAccount.getName().equals(account.getName()));
		assertThat(resultAccount.getBalance() == 400);
	}

	@Test
	public void withdrawMoneyFAIL() throws Exception {
		
		// GIVEN

		BankAccountException thrown = Assertions.assertThrows(BankAccountException.class, () -> {
	           //Code under test
			accountPort.findAccountById(40L);
	  });

	  Assertions.assertEquals("Account not found", thrown.getMessage());
	}

}
