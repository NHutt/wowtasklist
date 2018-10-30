package nhutt.harjoitustyo.wowtasklist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Character {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long characterId;
	
	private String name;
	private String className;
	private int level;
	private int ilvl;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "character")
	private List<Task> tasks;
	
	public Character(String name, String className, int level, int ilvl) {
		super();
		this.name = name;
		this.className = className;
		this.level = level;
		this.ilvl = ilvl;
	}
	
	public Character() {
		super();
		this.name = null;
		this.className = null;
		this.level = 0;
		this.ilvl = 0;
	}

	public Long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Long characterId) {
		this.characterId = characterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getIlvl() {
		return ilvl;
	}

	public void setIlvl(int ilvl) {
		this.ilvl = ilvl;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Character [characterId=" + characterId + ", name=" + name + ", className=" + className + ", level="
				+ level + ", ilvl=" + ilvl + "]";
	}
	
	
	

}
