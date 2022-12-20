package exalt.bankaccount.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import exalt.bankaccount.application.port.in.WithdrawMoneyUseCase;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class WithdrawMoneyService implements WithdrawMoneyUseCase {

	private AccountPort accountPort;
	private CreateOperationService createOperationService;

	@Override
	public Account withdrawMoney(Long accountId, float amount) {
		log.info("withdraw Money from account Id: {} with amount {}",accountId,amount);
		Account accountModified = accountPort.findAccountById(accountId);
		accountModified.setBalance(accountModified.getBalance() - amount);
		Operation operation = createOperationService.createOperation("withdraw", amount, accountModified.getBalance());
		accountModified.getOperations().add(operation);
		return accountPort.save(accountModified);
	}

}
