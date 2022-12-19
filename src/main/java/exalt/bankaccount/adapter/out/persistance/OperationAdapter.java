package exalt.bankaccount.adapter.out.persistance;

import exalt.bankaccount.application.port.out.OperationPort;
import exalt.bankaccount.domain.Operation;

public class OperationAdapter implements OperationPort{

    private OperationRepository operationRepository;

	@Override
	public Operation save(Operation operation) {
        return operationRepository.save(operation);
	}

}
