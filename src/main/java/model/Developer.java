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
public class Developer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public Developer() {
		super();
	}
	
	public Developer(String name) {
		super();
		this.name = name;
	}
	
	public Developer(int id, String name) {
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
