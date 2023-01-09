package exalt.bankaccount.adapter.in.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import exalt.bankaccount.adapter.out.persistance.AccountRepository;
import exalt.bankaccount.adapter.out.persistance.OperationAdapter;
import exalt.bankaccount.adapter.out.persistance.OperationRepository;
import exalt.bankaccount.application.port.in.DepositMoneyUseCase;
import exalt.bankaccount.application.port.in.WithdrawMoneyUseCase;
import exalt.bankaccount.domain.Account;

@AutoConfigureMockMvc
@SpringBootTest
public class AccountControllerTest {

	@Autowired(required = true)
	private MockMvc mvc;

	@Autowired
	AccountRepository accountRepository;

	@MockBean
	DepositMoneyUseCase depositMoneyUseCase;

	@MockBean
	WithdrawMoneyUseCase withdrawMoneyUseCase;

	@MockBean
	OperationRepository operationRepository;

	@MockBean
	OperationAdapter operationAdapter;

	@BeforeEach
	void setUp() {
		accountRepository.deleteAll();
	}

	@Test
	public void depositMoney() throws Exception {
		Account account = Account.builder().balance(500).name("testAccount").build();
		account = accountRepository.save(account);
		mvc.perform(MockMvcRequestBuilders.post("/account/deposit").param("accountId", account.getId().toString())
				.param("amount", "10").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void withdrawMoney() throws Exception {
		Account account = Account.builder().balance(500).name("testAccount").build();
		account = accountRepository.save(account);
		mvc.perform(MockMvcRequestBuilders.post("/account/withdraw").param("accountId", account.getId().toString())
				.param("amount", "10").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
						;
	}
}
