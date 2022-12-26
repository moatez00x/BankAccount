package exalt.bankaccount.adapter.out.persistance;

import java.util.Optional;

import org.springframework.stereotype.Component;

import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.domain.Account;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@Component
@AllArgsConstructor
public class AccountAdapter implements AccountPort {

	private  AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Optional<Account> findAccountById(Long id) {
		return accountRepository.findById(id);
	}

}
