package exalt.bankaccount.application.port.out;

import java.util.Optional;

import exalt.bankaccount.domain.Account;


public interface AccountPort {

	Optional<Account> findAccountById(Long id);
    Account save(Account account);


}
