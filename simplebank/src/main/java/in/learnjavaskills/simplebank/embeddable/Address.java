package in.learnjavaskills.simplebank.embeddable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address
{
	private String lineOne;
	
	private String lineTwo;
	
	private String city;
	
	private Integer zipCode;
	
	private String state;
	
	private String country;
}
