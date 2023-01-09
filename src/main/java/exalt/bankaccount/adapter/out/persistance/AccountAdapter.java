package exalt.bankaccount.adapter.out.persistance;

import org.springframework.stereotype.Component;

import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.config.BankAccountException;
import exalt.bankaccount.config.Codes;
import exalt.bankaccount.domain.Account;
import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class AccountAdapter implements AccountPort {

	private  AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account findAccountById(Long id) throws BankAccountException {
		return accountRepository.findById(id).orElseThrow(()-> new BankAccountException(Codes.AC_01));
	}

}
