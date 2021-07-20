package in.learnjavaskills.simplebank.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import in.learnjavaskills.simplebank.embeddable.Address;
import in.learnjavaskills.simplebank.embeddable.CustomerId;
import in.learnjavaskills.simplebank.enums.Roles;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"password"})
public class Customer
{
	@EmbeddedId
	private CustomerId customerId;
	
	private String password;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private Roles role;
	
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	@JsonManagedReference
	private Set<Transaction> transactions;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	@JsonManagedReference
	private Balance balance;
}
