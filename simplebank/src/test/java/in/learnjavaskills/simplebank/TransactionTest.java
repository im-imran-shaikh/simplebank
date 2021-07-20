package in.learnjavaskills.simplebank;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.learnjavaskills.simplebank.entities.Transaction;
import in.learnjavaskills.simplebank.repository.CustomerRepository;
import in.learnjavaskills.simplebank.repository.TransactionRepository;

@SpringBootTest
public class TransactionTest
{
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void addTransaction()
	{
		Transaction transaction = new Transaction();
		transaction.setDate(LocalDateTime.now().minusDays(20));
		transaction.setAmount(400L);
		transaction.setCustomer(customerRepository.findByCustomerIdEmail("imran@gmail.com"));
		transaction.setDescription("Own account");
		transactionRepository.save(transaction);
	}
}
