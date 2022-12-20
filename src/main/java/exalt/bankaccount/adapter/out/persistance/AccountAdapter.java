package exalt.bankaccount.adapter.out.persistance;

import org.springframework.stereotype.Component;

import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.domain.Account;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class AccountAdapter implements AccountPort {

	private AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account findAccountById(Long id) {
		return accountRepository.findById(id).get();
	}

}
