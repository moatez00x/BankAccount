package exalt.bankaccount.application.port.out;

import exalt.bankaccount.config.BankAccountException;
import exalt.bankaccount.domain.Account;


public interface AccountPort {

	Account findAccountById(Long id) throws BankAccountException;
    Account save(Account account);


}
