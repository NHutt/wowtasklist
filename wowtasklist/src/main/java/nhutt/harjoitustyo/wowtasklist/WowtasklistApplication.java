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
			log.info("lisätään muutama alue, hahmo ja tehtävä");
			
			zoneRepository.save(new Zone("Zandalar/Kul Tiras"));
			zoneRepository.save(new Zone("Broken Isles"));
			zoneRepository.save(new Zone("Dread Wastes"));
			zoneRepository.save(new Zone("Draenor"));
			zoneRepository.save(new Zone("Tomb of Sargeras"));
			zoneRepository.save(new Zone("Dungeons"));
			zoneRepository.save(new Zone("Battlegrounds"));
			zoneRepository.save(new Zone("Darkmoon Isle"));
			zoneRepository.save(new Zone("Suramar"));
			zoneRepository.save(new Zone("Icecrown Citadel"));
			
			characterRepository.save(new Character("Yvoss", "Hunter", 120, 340));
			characterRepository.save(new Character("Muzambi", "Druid", 110, 210));
			characterRepository.save(new Character("Zamree", "Priest", 110, 208));
			characterRepository.save(new Character("Ahatwa", "Warrior", 110, 211));
			characterRepository.save(new Character("Zeltharas", "Demon Hunter", 110, 210));
			characterRepository.save(new Character("Utoga", "Paladin", 110, 210));
			
			taskRepository.save(new Task("Reach exalted with Tortollan seekers", 120, "In progress", 
					characterRepository.findByName("Yvoss").get(0), zoneRepository.findByName("Zandalar/Kul Tiras").get(0)));
			taskRepository.save(new Task("Complete the Balance of Power questchain", 120, "Not started", 
					characterRepository.findByName("Muzambi").get(0), zoneRepository.findByName("Broken Isles").get(0)));
			taskRepository.save(new Task("Run Legion dungeons", 110, "5/30", 
					characterRepository.findByName("Zamree").get(0), zoneRepository.findByName("Dungeons").get(0)));
			taskRepository.save(new Task("Farm 25hc Deathbringer Saurfang for transmog belt", 110, "In progress", 
					characterRepository.findByName("Yvoss").get(0), zoneRepository.findByName("Icecrown Citadel").get(0)));
			taskRepository.save(new Task("Kill enemy players", 110, "952/1000", 
					characterRepository.findByName("Ahatwa").get(0), zoneRepository.findByName("Battlegrounds").get(0)));
			taskRepository.save(new Task("Farm the havoc hidden artifact skin", 110, "Not started", 
					characterRepository.findByName("Zeltharas").get(0), zoneRepository.findByName("Suramar").get(0)));
			taskRepository.save(new Task("Kill heroic Kil'jaeden", 120, "Requires leveling", 
					characterRepository.findByName("Utoga").get(0), zoneRepository.findByName("Tomb of Sargeras").get(0)));
			taskRepository.save(new Task("Do dailies and try to get achievements", 120, "In progress", 
					characterRepository.findByName("Yvoss").get(0), zoneRepository.findByName("Darkmoon Isle").get(0)));

			
			
		
			// Luodaan käyttäjä admin/admin
			User admin = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "mjaah@wraah.fi", "ADMIN");
				
				userRepository.save(admin);
			
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
