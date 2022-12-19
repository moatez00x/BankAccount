package exalt.bankaccount.application.service;

import org.springframework.stereotype.Service;
import exalt.bankaccount.application.port.in.DepositMoneyUseCase;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class DepositMoneyService implements DepositMoneyUseCase {

	private AccountPort accountPort;
	private CreateOperationService createOperationService;

	@Override
	public Account depositMoney(Long accountId, float amount) {
		Account accountModified = accountPort.findAccountById(accountId);
		accountModified.setBalance(accountModified.getBalance() + amount);
		Operation operation = createOperationService.createOperation("deposit", amount, accountModified.getBalance());
		accountModified.getOperations().add(operation);
		return accountPort.save(accountModified);
	}

}
