package exalt.bankaccount.application.port.in;

import exalt.bankaccount.domain.Account;

public interface DepositMoneyUseCase {
	
	Account depositMoney(Long accountId,float amount);

}
