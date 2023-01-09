package exalt.bankaccount.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import exalt.bankaccount.adapter.out.persistance.OperationRepository;
import exalt.bankaccount.application.port.out.OperationPort;
import exalt.bankaccount.domain.Operation;

@SpringBootTest
public class CreateOperationServiceTest {
	@Autowired
	OperationRepository operationRepository;
	@Autowired
	CreateOperationService createOperationService;
	@Autowired
	OperationPort operationPort;

	@AfterEach
	void setUp() {
		operationRepository.deleteAll();
	}

	@Test
	public void GIVEN_Operation_Params_WHEN_Create_Operation_THEN_return_Operation_Created() {

		// GIVEN
		Operation createdOperation = createOperationService.createOperation("deposit", 400, 1000);

		// WHEN
		Operation resultOperation = operationPort.findOperationById(createdOperation.getId());

		// THEN
		assertThat(resultOperation.getName().equals("deposit"));
		assertThat(resultOperation.getAmount() == 400);
		assertThat(resultOperation.getBalance() == 1000);

	}

}
