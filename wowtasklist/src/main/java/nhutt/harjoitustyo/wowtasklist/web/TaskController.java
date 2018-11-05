package nhutt.harjoitustyo.wowtasklist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nhutt.harjoitustyo.wowtasklist.domain.CharacterRepository;
import nhutt.harjoitustyo.wowtasklist.domain.Task;
import nhutt.harjoitustyo.wowtasklist.domain.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private CharacterRepository characterRepository;

	
	// Sisäänkirjautuminen
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
    
    // REST-palvelu, joka palauttaa kaikki tehtävät
    @RequestMapping(value="/tasks", method = RequestMethod.GET)
    public @ResponseBody List<Task> taskListRest() {	
        return (List<Task>) taskRepository.findAll();
    }   
    
	// REST-palvelu, joka palauttaa tehtävän tietyllä id:llä
    @RequestMapping(value="/tasks/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Task> findTaskRest(@PathVariable("id") Long taskId) {	
    	return taskRepository.findById(taskId);
    	
    	// Optional -> ei tule virheilmoitusta vaan null, jos haetaan id:tä,
    	// joka ei ole käytössä
    }       
	

	/** palauttaa listauksen kaikista tietokannan tehtävistä **/
	@RequestMapping(value="/tasklist", method=RequestMethod.GET)
	public String getTasklist(Model model) {
		model.addAttribute("tasks", taskRepository.findAll());
		
		return "tasklist";
	}
	
	/** poistaa tietyn tehtävän id:n perusteella **/
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable("id") Long taskId) {
		taskRepository.deleteById(taskId);
		
		return "redirect:../tasklist";
		
	}
	
	/** palauttaa tyhjän lomakkeen uuden tehtävän lisäämiseen **/
	@RequestMapping(value = "/add")
    public String addTask(Model model){
    	model.addAttribute("task", new Task());
    	model.addAttribute("characters", characterRepository.findAll());
        return "addtask";
    }  
	
	/** tallentaa tehtävän tiedot ja palaa listaukseen **/
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Task task){
        taskRepository.save(task);
        return "redirect:tasklist";
    }  
	
    /** palauttaa tietyn tehtävän editointisivun **/
	@RequestMapping(value = "/edit/{id}")
    public String editTask(@PathVariable("id") Long taskId, Model model) {
    	model.addAttribute("task", taskRepository.findById(taskId));
        return "edittask";
    }  

}
