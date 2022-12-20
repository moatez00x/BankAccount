package exalt.bankaccount.adapter.in.web;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exalt.bankaccount.application.port.in.CheckOperationsUseCase;
import exalt.bankaccount.application.port.in.DepositMoneyUseCase;
import exalt.bankaccount.application.port.in.WithdrawMoneyUseCase;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/account")
public class AccountController {
	private CheckOperationsUseCase checkOperationsUseCase;
	private DepositMoneyUseCase depositMoneyUseCase;
	private WithdrawMoneyUseCase withdrawMoneyUseCase;
	

	// Deposit Money API
	@PostMapping(value = "/deposit")
	public ResponseEntity<Account> depositMoney(@RequestParam Long accountId, @RequestParam float amount) {
		Account accountToUpdate  = depositMoneyUseCase.depositMoney(accountId, amount);
		return new ResponseEntity<>(accountToUpdate, HttpStatus.OK);
	}

	// withdraw Money API
	@PostMapping(value = "/withdraw")
	public ResponseEntity<Account> withdrawMoney(@RequestParam Long accountId, @RequestParam float amount) {
		Account accountToUpdate  = withdrawMoneyUseCase.withdrawMoney(accountId, amount);
		return new ResponseEntity<>(accountToUpdate, HttpStatus.OK);
	}

	// Get operations history API
	@GetMapping(value = "/operations")
	public List<Operation> getOperations(@RequestParam Long accountId) {
		return checkOperationsUseCase.CheckOperations(accountId);
	}

}
