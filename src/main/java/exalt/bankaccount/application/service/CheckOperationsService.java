package exalt.bankaccount.application.service;

import java.util.List;
import org.springframework.stereotype.Service;
import exalt.bankaccount.application.port.in.CheckOperationsUseCase;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CheckOperationsService implements CheckOperationsUseCase{

	private AccountPort accountPort;

	@Override
	public List<Operation> CheckOperations(Long accountId) {
		//find account
		Account account=accountPort.findAccountById(accountId);
		//get operations of that account
		List<Operation> history = account.getOperations();
		return history;
	}

}
