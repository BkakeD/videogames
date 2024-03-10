/**
 * @author Blake Dykstra - bdykstra
 * CIS175 - Spring 2024
 * Feb 4, 2024
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="games")
public class VideoGame {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	private String name;
	@ManyToOne
	private Developer developer;
	@ManyToOne
	private Publisher publisher;
	
	public VideoGame() {}
	
	public VideoGame(String name, Developer developer, Publisher publisher) {
		this.name = name;
		this.developer = developer;
		this.publisher = publisher;
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
	
	public Developer getDeveloper() {
		return developer;
	}
	
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}
	
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return this.name + ", made by: " + this.developer + ", published by: " + this.publisher;
	}
	
}
