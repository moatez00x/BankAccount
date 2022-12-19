package exalt.bankaccount.application.service;

import java.util.Date;
import exalt.bankaccount.adapter.out.persistance.OperationAdapter;
import exalt.bankaccount.application.port.in.CreateOperationUseCase;
import exalt.bankaccount.domain.Operation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateOperationService implements CreateOperationUseCase{
	private OperationAdapter operationAdapter;
	
	@Override
	public Operation createOperation(String name, float amount, float balance) {
		Operation operation = new Operation();
		operation.setBalance(balance);
		operation.setDate(new Date());
		operation.setName(name);
		return operationAdapter.save(operation);
	}

}
