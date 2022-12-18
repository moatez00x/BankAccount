package exalt.bankaccount.application.service;

import java.util.List;
import org.springframework.stereotype.Service;
import exalt.bankaccount.application.port.in.CheckOperationsUseCase;
import exalt.bankaccount.domain.Operation;

@Service
public class CheckOperationsService implements CheckOperationsUseCase{

	@Override
	public List<Operation> CheckOperations(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
