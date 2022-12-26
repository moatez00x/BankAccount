package exalt.bankaccount.application.service;

import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import exalt.bankaccount.adapter.out.persistance.OperationAdapter;
import exalt.bankaccount.application.port.in.CreateOperationUseCase;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.application.port.out.OperationPort;
import exalt.bankaccount.domain.Operation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CreateOperationService implements CreateOperationUseCase {
	private OperationPort operationPort;

	@Override
	public Operation createOperation(String name, float amount, float balance) {
		log.info("Create history operation: {}",name);
		Operation operation = new Operation();
		operation.setBalance(balance);
		operation.setDate(new Date());
		operation.setAmount(amount);
		operation.setName(name);
		log.info("Operation: {}",operationPort.save(operation));
		return operationPort.save(operation);
	}

}
