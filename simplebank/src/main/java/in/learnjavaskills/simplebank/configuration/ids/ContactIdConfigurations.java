package in.learnjavaskills.simplebank.configuration.ids;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Configuration;

import net.bytebuddy.utility.RandomString;

@Configuration
public class ContactIdConfigurations implements IdentifierGenerator
{
	private Random random = new Random();
	private RandomString randomString = new RandomString();
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException
	{	
		int number = random.nextInt(70000000);
		String start = randomString.make(3);
		String end = randomString.make(4);
		
		return start + number + end;
	}

}
