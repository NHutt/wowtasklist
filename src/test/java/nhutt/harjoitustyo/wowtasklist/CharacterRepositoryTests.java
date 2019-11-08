package nhutt.harjoitustyo.wowtasklist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import nhutt.harjoitustyo.wowtasklist.domain.Character;
import nhutt.harjoitustyo.wowtasklist.domain.CharacterRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CharacterRepositoryTests {
	
	@Autowired
	private CharacterRepository characterRepository;
	
	@Test
	public void createNewCharacter(){

		characterRepository.save(new Character("Ahatwa", "Warrior", 110, 210));
		characterRepository.findByName("Ahatwa").get(0).getCharacterId();
		
		assertThat(characterRepository.findByName("Ahatwa").get(0).getCharacterId()).isNotNull();

	}
	
	@Test
	public void deleteCharacter() {
		
		characterRepository.save(new Character("Ahatwa", "Warrior", 110, 210));
		Long id = characterRepository.findByName("Ahatwa").get(0).getCharacterId();
		characterRepository.deleteById(id);
		
		Optional<Character> deletedCharacter = characterRepository.findById(id);
		assertThat(deletedCharacter).isEmpty();

		
	}
	
}
