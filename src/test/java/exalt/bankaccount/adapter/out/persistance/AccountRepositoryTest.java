package exalt.bankaccount.adapter.out.persistance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import exalt.bankaccount.domain.Account;
@SpringBootTest
public class AccountRepositoryTest {

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
		assertThat(expectedAccount.getName().equals(account.getName()));
		assertThat(expectedAccount.getBalance()==account.getBalance());

	}
}
