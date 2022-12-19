package exalt.bankaccount.application.port.in;

import exalt.bankaccount.domain.Account;

public interface WithdrawMoneyUseCase {

	Account withdrawMoney(Long accountId,float amount);
}
