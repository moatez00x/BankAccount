package exalt.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import exalt.bankaccount.adapter.out.persistance.AccountRepository;
import exalt.bankaccount.domain.Account;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest

class BankaccountApplicationTests {

	@Autowired
	private AccountRepository accountRepository;

	@BeforeEach
	void setUp() {
		accountRepository.deleteAll();
	}

	@Test
	void GIVEN_account_WHEN_findById_THEN_return_account_with_specific_id() {

		// GIVEN
		Account account = Account.builder().balance(500).name("testAccount").build();
		account = accountRepository.save(account);

		// WHEN
		Account expectedAccount = accountRepository.findById(account.getId()).get();

		// THEN
		assertThat(expectedAccount.getName(), is(account.getName()));
		assertThat(expectedAccount.getBalance(), is(account.getBalance()));

	}
	// exception
//		asserThrows()

}
