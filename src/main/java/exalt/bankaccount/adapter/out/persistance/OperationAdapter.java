package exalt.bankaccount.adapter.out.persistance;

import org.springframework.stereotype.Component;

import exalt.bankaccount.application.port.out.OperationPort;
import exalt.bankaccount.domain.Operation;
import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class OperationAdapter implements OperationPort{

    private  OperationRepository operationRepository;

	@Override
	public Operation save(Operation operation) {
        return operationRepository.save(operation);
	}

	@Override
	public Operation findOperationById(Long id)  {
		return operationRepository.findById(id).get();
	}
}
