package in.learnjavaskills.simplebank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.learnjavaskills.simplebank.entities.Contact;
import in.learnjavaskills.simplebank.repository.ContactRepository;

@SpringBootTest
class SimplebankApplicationTests
{
	@Autowired
	private ContactRepository ContactRepository;
	
	@Test
	void addContact()
	{
		Contact contact = new Contact();
		contact.setEmail("Imran@gamil.com");
		contact.setFirstName("Imran");
		contact.setLastName("Shaikh");
		contact.setMessage("Hello, I would like to connect with you.");
		ContactRepository.save(contact);
	}

}
