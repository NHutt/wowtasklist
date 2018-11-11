package nhutt.harjoitustyo.wowtasklist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import nhutt.harjoitustyo.wowtasklist.domain.Character;
import nhutt.harjoitustyo.wowtasklist.domain.Task;
import nhutt.harjoitustyo.wowtasklist.domain.TaskRepository;
import nhutt.harjoitustyo.wowtasklist.domain.Zone;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTests {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Test
	public void createNewTask() {

		Task task = new Task("Do archaeology", 110, "In progress", new Character("Yvoss", "Hunter", 120, 340), new Zone("Dread Wastes"));
		taskRepository.save(task);
		
		assertThat(task.getTaskId()).isNotNull();
	}
	
	@Test
	public void deleteTask() {

		Task task = new Task("Do archaeology", 110, "In progress", new Character("Yvoss", "Hunter", 120, 340), new Zone("Dread Wastes"));
		taskRepository.save(task);
		
		Long id = task.getTaskId();
		
		taskRepository.deleteById(id);
		
		Optional<Task> deletedTask = taskRepository.findById(id);
		assertThat(deletedTask).isEmpty();
	}
	
	@Test
	public void findTaskById() {
		
		Task task = new Task("Do archaeology", 110, "In progress", new Character("Yvoss", "Hunter", 120, 340), new Zone("Dread Wastes"));
		taskRepository.save(task);
		
		Long id = task.getTaskId();
		
		assertThat(taskRepository.findById(id)).isNotNull();
	}
}
