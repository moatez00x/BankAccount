package exalt.bankaccount.application.port.in;

import exalt.bankaccount.domain.Operation;

public interface CreateOperationUseCase {

	Operation createOperation(String name,float amount, float balance);

}
