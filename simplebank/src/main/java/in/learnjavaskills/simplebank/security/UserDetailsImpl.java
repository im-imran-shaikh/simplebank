package in.learnjavaskills.simplebank.security;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import in.learnjavaskills.simplebank.entities.Customer;

public class UserDetailsImpl implements UserDetails
{
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Principal principal;
	
	public UserDetailsImpl(Customer customer)
	{
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return Collections.singleton(new SimpleGrantedAuthority(customer.getRole().toString()));
	}

	@Override
	public String getPassword()
	{
		return customer.getPassword();
	}

	@Override
	public String getUsername()
	{
		return principal.getName();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

}
