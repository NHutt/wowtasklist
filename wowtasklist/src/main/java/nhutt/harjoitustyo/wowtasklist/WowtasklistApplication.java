package nhutt.harjoitustyo.wowtasklist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nhutt.harjoitustyo.wowtasklist.domain.Character;
import nhutt.harjoitustyo.wowtasklist.domain.CharacterRepository;
import nhutt.harjoitustyo.wowtasklist.domain.Task;
import nhutt.harjoitustyo.wowtasklist.domain.TaskRepository;
import nhutt.harjoitustyo.wowtasklist.domain.User;
import nhutt.harjoitustyo.wowtasklist.domain.UserRepository;
import nhutt.harjoitustyo.wowtasklist.domain.Zone;
import nhutt.harjoitustyo.wowtasklist.domain.ZoneRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class WowtasklistApplication {
	private static final Logger log = LoggerFactory.getLogger(WowtasklistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WowtasklistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner taskDemo(TaskRepository taskRepository, CharacterRepository characterRepository, ZoneRepository zoneRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("lisätään muutama tehtävä ja hahmo");
			
			zoneRepository.save(new Zone("Zandalar/Kul Tiras"));
			zoneRepository.save(new Zone("Broken Isles"));
			
			characterRepository.save(new Character("Yvoss", "Hunter", 120, 340));
			characterRepository.save(new Character("Muzambi", "Druid", 110, 210));
			taskRepository.save(new Task("Reach exalted with Tortollan seekers", 120, "In progress", 
					characterRepository.findByName("Yvoss").get(0), zoneRepository.findByName("Zandalar/Kul Tiras").get(0)));
			taskRepository.save(new Task("Complete the Balance of Power questchain", 120, "Not started", 
					characterRepository.findByName("Muzambi").get(0), zoneRepository.findByName("Broken Isles").get(0)));

		
			// Luodaan käyttäjät user/user ja admin/admin
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "waah@blaah.fi", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "mjaah@wraah.fi", "ADMIN");
				
				userRepository.save(user1);
				userRepository.save(user2);
			
			log.info("haetaan kaikki tehtävät");
			for (Task task : taskRepository.findAll()) {
				log.info(task.toString());
			}
			
			log.info("haetaan kaikki hahmot");
			for (Character character : characterRepository.findAll()) {
				log.info(character.toString());
			}
			
			log.info("haetaan kaikki alueet");
			for (Zone zone : zoneRepository.findAll()) {
				log.info(zone.toString());
			}
			
			log.info("haetaan kaikki käyttäjät");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}

		};
}
	
}
