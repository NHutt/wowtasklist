package nhutt.harjoitustyo.wowtasklist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import nhutt.harjoitustyo.wowtasklist.domain.Zone;
import nhutt.harjoitustyo.wowtasklist.domain.ZoneRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ZoneRepositoryTests {

	@Autowired
	private ZoneRepository zoneRepository;
	
	@Test
	public void createNewZone() {

		zoneRepository.save(new Zone("Draenor"));
		
		List<Zone> zones = zoneRepository.findByName("Draenor");
		
		assertThat(zones).hasSize(1);
		assertThat(zones.get(0).getName()).isEqualTo("Draenor");
	}
	
	@Test
	public void deleteZone() {

		zoneRepository.save(new Zone("Draenor"));
		
		List<Zone> zones = zoneRepository.findByName("Draenor");
		
		Long id = zones.get(0).getZoneId();
		
		zoneRepository.deleteById(id);
		
		assertThat(zoneRepository.findById(id)).isEmpty();
	}
	
}
