package exalt.bankaccount.application.service;

import org.springframework.stereotype.Service;
import exalt.bankaccount.application.port.in.DepositMoneyUseCase;
import exalt.bankaccount.domain.Account;

@Service
public class DepositMoneyService implements DepositMoneyUseCase{

	@Override
	public Account depositMoney(String accountId, float amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
