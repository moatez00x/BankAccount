package exalt.bankaccount.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exalt.bankaccount.domain.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long>{

}
