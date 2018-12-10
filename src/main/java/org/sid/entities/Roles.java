package org.sid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Roles implements Serializable {
	
	
	/*@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRole;*/
	@Id
	private String role;
	
	
	
	public Roles(String role) {
		super();
		this.role = role;
	}

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getRole() {
		return role;
	}
	public void setNomRole(String role) {
		this.role = role;
	}

	
}
