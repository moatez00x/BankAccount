package exalt.bankaccount.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import exalt.bankaccount.adapter.out.persistance.AccountRepository;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.domain.Account;

@SpringBootTest
public class WithdrawMoneyServiceTest {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	WithdrawMoneyService withdrawMoneyService;
	@MockBean
	AccountPort accountPort;
	@MockBean
	CreateOperationService createOperationService;

	@Test
	public void withdrawMoneySuccess() throws Exception {
		// GIVEN
		Account account = Account.builder().balance(500).name("testAccount").build();
		account = accountRepository.save(account);

		// WHEN
		Account resultAccount = withdrawMoneyService.withdrawMoney(account.getId(), 100);

		// THEN
		assertThat(resultAccount.getName().equals(account.getName()));
		assertThat(resultAccount.getBalance() == 400);

	}

	
//	@Test
//	public void withdrawMoneyfail() throws Exception {
//
//	}

	// exception
//	asserThrows()
}
