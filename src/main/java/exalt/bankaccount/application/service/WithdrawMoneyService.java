package exalt.bankaccount.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import exalt.bankaccount.application.port.in.WithdrawMoneyUseCase;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class WithdrawMoneyService implements WithdrawMoneyUseCase {

	private AccountPort accountPort;
	private CreateOperationService createOperationService;

	@Override
	public Account withdrawMoney(Long accountId, float amount) {
		// find the account to modify
		Account accountModified = accountPort.findAccountById(accountId);
		// apply operation to the balance
		accountModified.setBalance(accountModified.getBalance() - amount);
		// create operation history
		Operation operation = createOperationService.createOperation("withdraw", amount, accountModified.getBalance());
		accountModified.getOperations().add(operation);
		return accountPort.save(accountModified);
	}

}
