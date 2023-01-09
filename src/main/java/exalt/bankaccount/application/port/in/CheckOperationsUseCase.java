package exalt.bankaccount.application.port.in;

import java.util.List;

import exalt.bankaccount.config.BankAccountException;
import exalt.bankaccount.domain.Operation;


public interface CheckOperationsUseCase {
	
	List<Operation> CheckOperations(Long accountId) throws BankAccountException;

}
