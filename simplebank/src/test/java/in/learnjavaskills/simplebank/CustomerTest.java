package in.learnjavaskills.simplebank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.learnjavaskills.simplebank.embeddable.Address;
import in.learnjavaskills.simplebank.embeddable.CustomerId;
import in.learnjavaskills.simplebank.entities.Customer;
import in.learnjavaskills.simplebank.repository.CustomerRepository;

@SpringBootTest
public class CustomerTest
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void addCustomer()
	{
		Customer customer = new Customer();
		customer.setAddress(new Address("line one", "line two", "city", 1234567890, "state", "country"));
		customer.setCustomerId(new CustomerId(98765432158L, "imran@gmail.com", "imran.shaikh"));
		customer.setFirstName("Imran");
		customer.setLastName("Shaikh");
		customer.setPassword("imran");
		
		Customer save = customerRepository.save(customer);
		System.out.println(save);
	}
}
