package exalt.bankaccount.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import exalt.bankaccount.application.port.in.DepositMoneyUseCase;
import exalt.bankaccount.application.port.in.WithdrawMoneyUseCase;
import exalt.bankaccount.config.BankAccountException;
import exalt.bankaccount.domain.Account;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/account")
public class AccountController {
	private DepositMoneyUseCase depositMoneyUseCase;
	private WithdrawMoneyUseCase withdrawMoneyUseCase;
	

	@PostMapping(value = "/deposit")
	public ResponseEntity<Account> depositMoney(@RequestParam Long accountId, @RequestParam float amount) throws BankAccountException {
		Account accountToUpdate  = depositMoneyUseCase.depositMoney(accountId, amount);
		return new ResponseEntity<>(accountToUpdate, HttpStatus.OK);
	}

	@PostMapping(value = "/withdraw")
	public ResponseEntity<Account> withdrawMoney(@RequestParam Long accountId, @RequestParam float amount) throws BankAccountException {
		Account accountToUpdate  = withdrawMoneyUseCase.withdrawMoney(accountId, amount);
		return new ResponseEntity<>(accountToUpdate, HttpStatus.OK);
	}



}
