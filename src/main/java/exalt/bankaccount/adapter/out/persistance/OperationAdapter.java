package exalt.bankaccount.adapter.out.persistance;

import org.springframework.stereotype.Component;

import exalt.bankaccount.application.port.out.OperationPort;
import exalt.bankaccount.domain.Operation;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class OperationAdapter implements OperationPort{

    private OperationRepository operationRepository;

	@Override
	public Operation save(Operation operation) {
        return operationRepository.save(operation);
	}

}
