package exalt.bankaccount.application.port.out;

import exalt.bankaccount.domain.Account;


public interface AccountPort {

    Account findAccountById(Long id);
    Account save(Account account);


}
