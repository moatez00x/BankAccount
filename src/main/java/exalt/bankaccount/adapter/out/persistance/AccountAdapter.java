package exalt.bankaccount.adapter.out.persistance;


import org.springframework.beans.factory.annotation.Autowired;
import exalt.bankaccount.application.port.out.AccountPort;
import exalt.bankaccount.application.service.CheckOperationsService;
import exalt.bankaccount.application.service.DepositMoneyService;
import exalt.bankaccount.application.service.WithdrawMoneyService;
import exalt.bankaccount.domain.Account;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountAdapter implements AccountPort{
	
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
	@Override
	public Account findAccountById(Long id) {
		return accountRepository.findById(id).get();
	}
	
	
	
}
