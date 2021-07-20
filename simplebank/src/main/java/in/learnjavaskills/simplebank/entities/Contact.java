package in.learnjavaskills.simplebank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contact
{
	@Id
	@GenericGenerator(name = "contact_id_generator", strategy = "in.learnjavaskills.simplebank.configuration.ids.ContactIdConfigurations")
	@GeneratedValue(generator = "contact_id_generator")
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	@NotNull
	private String email;
	
	private String message;
}
