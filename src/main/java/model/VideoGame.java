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
import javax.persistence.Table;

@Entity
@Table(name="games")
public class VideoGame {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="DEVELOPER")
	private String developer;
	@Column(name="PUBLISHER")
	private String publisher;
	
	public VideoGame() {}
	
	public VideoGame(String name, String developer, String publisher) {
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
	
	public String getDeveloper() {
		return developer;
	}
	
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String returnGameDetails() {
		return this.name + ", made by: " + this.developer + ", published by: " + this.publisher;
	}
	
}
