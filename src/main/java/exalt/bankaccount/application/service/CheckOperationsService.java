package exalt.bankaccount.application.service;

import java.util.List;

import exalt.bankaccount.config.BankAccountException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exalt.bankaccount.application.port.in.CheckOperationsUseCase;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CheckOperationsService implements CheckOperationsUseCase{

	private final AccountPort accountPort;

	@Override
	public List<Operation> CheckOperations(Long accountId) throws BankAccountException {
		log.info("Get history operations of account : {}",accountId);
		Account account=getAccountById(accountId);
		List<Operation> history = account.getOperations();
		log.info("Getting {} Operations",history.size());
		return history;
	}

	
	private Account getAccountById(Long accountId) throws BankAccountException {
		return accountPort.findAccountById(accountId);
	}
}
