package org.sid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Produit implements Serializable{
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduit;
	
	private String nomProduit;
	private String descProduit;
	
	@OneToMany(mappedBy="produitDossier",cascade=CascadeType.ALL)
	private List<Dossier> dossierProduit;
	
	
	
	public Produit(String nomProduit) {
		super();
		this.nomProduit = nomProduit;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getDescProduit() {
		return descProduit;
	}
	public void setDescProduit(String descProduit) {
		this.descProduit = descProduit;
	}
	public List<Dossier> getDossierProduit() {
		return dossierProduit;
	}
	public void setDossierProduit(List<Dossier> dossierProduit) {
		this.dossierProduit = dossierProduit;
	}
	
	
	

}
