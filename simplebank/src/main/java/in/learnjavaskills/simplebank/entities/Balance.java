package in.learnjavaskills.simplebank.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Balance
{
	private Long id;
	
	private Long balance;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = { @JoinColumn(name="customerPhoneNumber", referencedColumnName = "phoneNumber"),
			@JoinColumn(name = "customerEmail", referencedColumnName = "email"),
			@JoinColumn(name = "customerUserName", referencedColumnName = "userName")})
	@JsonBackReference
	private Customer customer;
}
