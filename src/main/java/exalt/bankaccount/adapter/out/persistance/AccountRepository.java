package exalt.bankaccount.adapter.out.persistance;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exalt.bankaccount.domain.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
	Optional<Account> findById(Long id);
}
