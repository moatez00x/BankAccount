package exalt.bankaccount.application.service;

import org.springframework.stereotype.Service;
import exalt.bankaccount.application.port.in.WithdrawMoneyUseCase;
import exalt.bankaccount.domain.Account;

@Service
public class WithdrawMoneyService implements WithdrawMoneyUseCase{

	@Override
	public Account withdrawMoney(String accountId, float amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
