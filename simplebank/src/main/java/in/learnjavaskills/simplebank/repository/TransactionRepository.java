package in.learnjavaskills.simplebank.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.learnjavaskills.simplebank.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>
{
	Set<Transaction> findByPhoneNumberOrEmailOrUserName(Long phoneNumber, String email, String username);
}
