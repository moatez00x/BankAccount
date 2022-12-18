package exalt.bankaccount.application.port.in;

import exalt.bankaccount.domain.Account;

public interface WithdrawMoneyUseCase {

	Account withdrawMoney(String accountId,float amount);
}
