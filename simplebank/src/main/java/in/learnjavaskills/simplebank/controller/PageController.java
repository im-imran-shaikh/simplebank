package in.learnjavaskills.simplebank.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.learnjavaskills.simplebank.entities.Contact;
import in.learnjavaskills.simplebank.entities.Customer;
import in.learnjavaskills.simplebank.entities.Transaction;
import in.learnjavaskills.simplebank.repository.ContactRepository;
import in.learnjavaskills.simplebank.repository.CustomerRepository;
import in.learnjavaskills.simplebank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PageController
{
	private final ContactRepository contactRepository;
	private final CustomerRepository CustomerRepository;
	private final TransactionRepository transactionRepository;
	
	@PostMapping("contact")
	public String contact(@RequestBody Contact contact)
	{
		return contactRepository.save(contact).getId();
	}
	
	@GetMapping("customer")
	public Customer getCustomer(Principal principal)
	{
		String username = principal.getName();
		return CustomerRepository.findByCustomerIdPhoneNumberOrCustomerIdEmailOrCustomerIdUserName(Long.parseLong(username), username, username);
	}
	
	@GetMapping("transaction")
	public Set<Transaction> getTransactionOf(String username)
	{
		return transactionRepository.findByPhoneNumberOrEmailOrUserName(Long.parseLong(username), username, username);
	}
	
	@PostMapping("adduser")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return CustomerRepository.save(customer);
	}
}
