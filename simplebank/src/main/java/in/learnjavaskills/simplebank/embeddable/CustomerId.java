package in.learnjavaskills.simplebank.embeddable;

import java.io.Serializable;

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
public class CustomerId implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long phoneNumber;
	
	private String email;
	
	private String userName;
}
