package org.sid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Armoire implements Serializable{
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long idArmoire;
	 @Column(unique=true)
	private String codeArmoire;
	
	
	@OneToMany(mappedBy="armoire" ,cascade=CascadeType.ALL)
	private List<Boite> boites;
	
	
	
	public Armoire(String codeArmoire) {
		super();
		this.codeArmoire = codeArmoire;
	}

	public Armoire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdArmoire() {
		return idArmoire;
	}
	public void setIdArmoire(Long idArmoire) {
		this.idArmoire = idArmoire;
	}
	public String getCodeArmoire() {
		return codeArmoire;
	}
	public void setCodeArmoire(String codeArmoire) {
		this.codeArmoire = codeArmoire;
	}
	public List<Boite> getBoites() {
		return boites;
	}
	public void setBoites(List<Boite> boites) {
		this.boites = boites;
	}
	
}
