package exalt.bankaccount.adapter.out.persistance;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import exalt.bankaccount.domain.Operation;

@SpringBootTest
public class OperationRepositoryTest {

	@Autowired
	private OperationRepository operationRepository;

	@BeforeEach
	void setUp() {
		operationRepository.deleteAll();
	}

	@Test
	void GIVEN_account_WHEN_findById_THEN_return_account_with_specific_id() {

		// GIVEN
		Operation operation = Operation.builder().name("withdraw").amount(400).balance(100l).date(new Date()).build();
		operation = operationRepository.save(operation);

		// WHEN
		Operation expectedOperation = operationRepository.findById(operation.getId()).get();

		// THEN
		assertThat(expectedOperation.getName().equals(operation.getName()));
		assertThat(expectedOperation.getBalance() == operation.getBalance());

	}
}