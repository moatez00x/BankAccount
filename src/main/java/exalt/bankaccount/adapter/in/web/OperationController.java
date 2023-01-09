package exalt.bankaccount.adapter.in.web;

import java.util.List;

import exalt.bankaccount.config.BankAccountException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import exalt.bankaccount.application.port.in.CheckOperationsUseCase;
import exalt.bankaccount.domain.Operation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/operation")
public class OperationController {
	private CheckOperationsUseCase checkOperationsUseCase;

	@GetMapping(value = "/all")
	public List<Operation> getOperations(@RequestParam Long accountId) throws BankAccountException {
		return checkOperationsUseCase.CheckOperations(accountId);
	}
}
