package exalt.bankaccount.application.service;

import java.util.List;

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
	public List<Operation> CheckOperations(Long accountId) {
		log.info("Get history operations of account : {}",accountId);
		Account account=accountPort.findAccountById(accountId).get();
		List<Operation> history = account.getOperations();
		log.info("Getting {} Operations",history.size());
		return history;
	}

}
