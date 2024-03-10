/**
 * @author Blake Dykstra - bdykstra
 * CIS175 - Spring 2024
 * Feb 23, 2024
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public Publisher() {
		super();
	}
	
	public Publisher(String name) {
		super();
		this.name = name;
	}
	
	public Publisher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;	
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
