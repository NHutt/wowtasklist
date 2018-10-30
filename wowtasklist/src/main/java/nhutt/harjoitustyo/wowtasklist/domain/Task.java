package nhutt.harjoitustyo.wowtasklist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long taskId;
	
	private String description;
	private int levelreq;
	private String status;
	
	@JsonIgnore
	@ManyToOne
	
	@JoinColumn(name = "characterId")
	private Character character;
	
	@JsonIgnore
	@ManyToOne
	
	@JoinColumn(name = "zoneId")
	private Zone zone;
	
	
	public Task(String description, int levelreq, String status) {
		super();
		this.description = description;
		this.levelreq = levelreq;
		this.status = status;
	}
	
	public Task() {
		super();
		this.description = null;
		this.levelreq = 0;
		this.status = null;
		this.character = null;
		this.zone = null;
	}
	
	public Task(String description, int levelreq, String status, Character character, Zone zone) {
		super();
		this.description = description;
		this.levelreq = levelreq;
		this.status = status;
		this.character = character;
		this.zone = zone;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevelreq() {
		return levelreq;
	}

	public void setLevelreq(int levelreq) {
		this.levelreq = levelreq;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		if (this.character != null && this.zone != null)
		return "Task [taskId=" + taskId + ", description=" + description + ", levelreq=" + levelreq + ", status="
				+ status + ", character=" + this.getCharacter() + ", zone=" + this.getZone() + "]";
		else
			return "Task [taskId=" + taskId + ", description=" + description + ", levelreq=" + levelreq + ", status="
			+ status + "]";
	}
	
	
	
	
	
	

}
