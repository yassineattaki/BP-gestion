package org.sid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Motif implements Serializable{
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMotif;
	 @Column(unique=true)
	private String nomMotif;
	
	@OneToMany(mappedBy="motifMvmnt",cascade=CascadeType.ALL)
	private List<Mouvement>  mvmntMotif;
	
	
	
	public Motif(String nomMotif) {
		super();
		this.nomMotif = nomMotif;
	}
	
	public Motif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdMotif() {
		return idMotif;
	}
	public void setIdMotif(int idMotif) {
		this.idMotif = idMotif;
	}
	public String getNomMotif() {
		return nomMotif;
	}
	public void setNomMotif(String nomMotif) {
		this.nomMotif = nomMotif;
	}
	public List<Mouvement> getMvmntMotif() {
		return mvmntMotif;
	}
	public void setMvmntMotif(List<Mouvement> mvmntMotif) {
		this.mvmntMotif = mvmntMotif;
	}
	

}
