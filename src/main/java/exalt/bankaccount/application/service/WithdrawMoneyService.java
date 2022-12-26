package exalt.bankaccount.application.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exalt.bankaccount.adapter.out.persistance.AccountAdapter;
import exalt.bankaccount.application.port.in.WithdrawMoneyUseCase;
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
public class WithdrawMoneyService implements WithdrawMoneyUseCase {

	private AccountPort accountPort;
	private CreateOperationService createOperationService;

	@Override
	public Account withdrawMoney(Long accountId, float amount) throws BankAccountException {
		
		log.info("withdraw Money from account Id: {} with amount {}",accountId,amount);
		
		Account accountModified = accountPort.findAccountById(accountId)
				.orElseThrow(()->new BankAccountException(Codes.AC_01));	
		if(accountModified.getBalance()>= amount && amount !=0) {
		accountModified.setBalance(accountModified.getBalance() - amount);
		Operation operation = createOperationService.createOperation("withdraw", amount, accountModified.getBalance());
	 
		ArrayList<Operation> NOperations= new ArrayList(accountModified.getOperations());
		NOperations.add(operation);
		accountModified.setOperations(NOperations);
		
		log.info("accountModified",accountModified.getName());

		}
		else if(amount> accountModified.getBalance()) {throw new BankAccountException(Codes.AC_02);}
		else if(amount== 0) {throw new BankAccountException(Codes.AC_03);}
		
			
		return accountPort.save(accountModified);
	}

}
