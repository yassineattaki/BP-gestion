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
public class Boite implements Serializable{
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBoite;
	 @Column(unique=true)
	private String codeBoite;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Armoire armoire;
	
	@OneToMany(mappedBy="boiteDossier",cascade=CascadeType.ALL)
	private List<Dossier> dossierBoite;
	
	
	public Boite(String codeBoite) {
		super();
		this.codeBoite = codeBoite;
	}
	public Boite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdBoite() {
		return idBoite;
	}
	public void setIdBoite(int idBoite) {
		this.idBoite = idBoite;
	}
	public String getCodeBoite() {
		return codeBoite;
	}
	public void setCodeBoite(String codeBoite) {
		this.codeBoite = codeBoite;
	}
	public Armoire getArmoire() {
		return armoire;
	}
	public void setArmoire(Armoire armoire) {
		this.armoire = armoire;
	}
	public List<Dossier> getDossierBoite() {
		return dossierBoite;
	}
	public void setDossierBoite(List<Dossier> dossierBoite) {
		this.dossierBoite = dossierBoite;
	}
	

}
