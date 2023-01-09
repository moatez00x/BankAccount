package exalt.bankaccount.application.port.out;

import exalt.bankaccount.domain.Operation;

public interface OperationPort {
    Operation save(Operation operation);
    Operation findOperationById(Long id);
}
