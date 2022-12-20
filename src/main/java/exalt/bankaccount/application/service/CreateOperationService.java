package exalt.bankaccount.application.service;

import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import exalt.bankaccount.adapter.out.persistance.OperationAdapter;
import exalt.bankaccount.application.port.in.CreateOperationUseCase;
import exalt.bankaccount.domain.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CreateOperationService implements CreateOperationUseCase {
	private OperationAdapter operationAdapter;

	@Override
	public Operation createOperation(String name, float amount, float balance) {
		log.info("Create history operation: {}",name);
		Operation operation = new Operation();
		operation.setBalance(balance);
		operation.setDate(new Date());
		operation.setName(name);
		return operationAdapter.save(operation);
	}

}
