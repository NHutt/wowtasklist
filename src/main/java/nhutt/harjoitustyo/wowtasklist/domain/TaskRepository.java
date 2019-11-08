package nhutt.harjoitustyo.wowtasklist.domain;

import org.springframework.data.repository.CrudRepository;

import nhutt.harjoitustyo.wowtasklist.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{

}
