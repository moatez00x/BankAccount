package exalt.bankaccount.application.service;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import exalt.bankaccount.application.port.in.DepositMoneyUseCase;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.config.BankAccountException;
import exalt.bankaccount.config.Codes;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DepositMoneyService implements DepositMoneyUseCase {

	private AccountPort accountPort;
	private CreateOperationService createOperationService;

	@Override
	public Account depositMoney(Long accountId, float amount) throws BankAccountException {
		log.info("deposit Money to account Id: {} with amount {}",accountId,amount);
		Account accountModified = accountPort.findAccountById(accountId);
		if(amount== 0) {throw new BankAccountException(Codes.AC_03);}
		else { 
			accountModified.setBalance(accountModified.getBalance() + amount);
		}
		Operation operation = createOperationService.createOperation("deposit", amount, accountModified.getBalance());
		accountModified.getOperations().add(operation);
		return accountPort.save(accountModified);
	}

}
