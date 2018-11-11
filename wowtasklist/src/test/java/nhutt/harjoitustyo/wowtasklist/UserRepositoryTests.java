package nhutt.harjoitustyo.wowtasklist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import nhutt.harjoitustyo.wowtasklist.domain.User;
import nhutt.harjoitustyo.wowtasklist.domain.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void createNewUser() {
		User tyyppi = new User("tyyppi", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "alrighty@o.fi", "USER");
		userRepository.save(tyyppi);
		assertThat(tyyppi.getId()).isNotNull();
	}  
	
	@Test
	public void deleteUser() {
		User tyyppi = new User("tyyppi", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "alrighty@o.fi", "USER");
		userRepository.save(tyyppi);
		
		Long id = tyyppi.getId();
		
		userRepository.deleteById(id);
		
		Optional<User> deletedUser = userRepository.findById(id);
		assertThat(deletedUser).isEmpty();
	}  
	
	@Test
	public void findUserById() {
		User tyyppi = new User("tyyppi", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "alrighty@o.fi", "USER");
		userRepository.save(tyyppi);
		
		Long id = tyyppi.getId();
		
		assertThat(userRepository.findById(id)).isNotNull();
	}  


}
