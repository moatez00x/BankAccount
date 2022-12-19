package exalt.bankaccount.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import exalt.bankaccount.domain.Account;
import exalt.bankaccount.domain.Operation;

public interface OperationRepository extends JpaRepository<Operation,Long>{

}
