package nhutt.harjoitustyo.wowtasklist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Zone {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long zoneId;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "zone")
	private List<Task> tasks;

	public Zone(String name) {
		super();
		this.name = name;
	}
	
	public Zone() {
		super();
		this.name = null;
	}

	public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Zone [zoneId=" + zoneId + ", name=" + name + "]";
	}

}
