package in.learnjavaskills.simplebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.learnjavaskills.simplebank.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	Customer findByCustomerIdPhoneNumberOrCustomerIdEmailOrCustomerIdUserName(Long phoneNumber, String email, String username);
	
	Customer findByCustomerIdEmail(String email);
}
