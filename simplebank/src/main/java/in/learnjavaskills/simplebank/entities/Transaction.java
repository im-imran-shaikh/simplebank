package in.learnjavaskills.simplebank.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction
{
	@Id
	@GenericGenerator(name = "transaction_id_generator", strategy = "in.learnjavaskills.simplebank.configuration.ids.ContactIdConfigurations")
	@GeneratedValue(generator = "transaction_id_generator")
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	private LocalDateTime date;
	
	private String description;
	
	private Long amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = { @JoinColumn(name="customerPhoneNumber", referencedColumnName = "phoneNumber"),
				@JoinColumn(name = "customerEmail", referencedColumnName = "email"),
				@JoinColumn(name = "customerUserName", referencedColumnName = "userName")})
	@JsonBackReference
	private Customer customer;
	
}
