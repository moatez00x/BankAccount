package exalt.bankaccount.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exalt.bankaccount.application.port.in.CheckOperationsUseCase;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
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
