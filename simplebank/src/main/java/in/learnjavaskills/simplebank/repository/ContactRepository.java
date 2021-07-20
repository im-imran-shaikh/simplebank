package in.learnjavaskills.simplebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.learnjavaskills.simplebank.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>
{

}
