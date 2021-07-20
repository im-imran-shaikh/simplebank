package in.learnjavaskills.simplebank.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.learnjavaskills.simplebank.entities.Customer;
import in.learnjavaskills.simplebank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService
{
	private final CustomerRepository CustomerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Customer customer = CustomerRepository
				.findByCustomerIdPhoneNumberOrCustomerIdEmailOrCustomerIdUserName(Long.parseLong(username), username, username);
		
		return new UserDetailsImpl(customer);
	}

}
