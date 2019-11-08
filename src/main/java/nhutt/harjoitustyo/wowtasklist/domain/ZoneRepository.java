package nhutt.harjoitustyo.wowtasklist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nhutt.harjoitustyo.wowtasklist.domain.Zone;

public interface ZoneRepository extends CrudRepository<Zone, Long>{

	List<Zone> findByName(String name);

}
