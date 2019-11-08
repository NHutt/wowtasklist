package nhutt.harjoitustyo.wowtasklist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nhutt.harjoitustyo.wowtasklist.domain.Character;

public interface CharacterRepository extends CrudRepository<Character, Long>{

	List<Character> findByName(String name);

}
