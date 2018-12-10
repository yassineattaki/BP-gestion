package org.sid.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Dossier implements Serializable {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDossier;
	
	 @Column(unique=true)
	private String codeDossier;
	private Date dateCreation;
	private int dureeLegale;
	private String dureeConv;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Produit produitDossier;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Boite boiteDossier;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Users userDossier;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Mouvement mvmntDossier;
	
	
	
	public Dossier(String codeDossier, Date dateCreation, int dureeLegale, String dureeConv) {
		super();
		this.codeDossier = codeDossier;
		this.dateCreation = dateCreation;
		this.dureeLegale = dureeLegale;
		this.dureeConv = dureeConv;
	}
	public Dossier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdDossier() {
		return idDossier;
	}
	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}
	public String getCodeDossier() {
		return codeDossier;
	}
	public void setCodeDossier(String codeDossier) {
		this.codeDossier = codeDossier;
	}
	
	
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getDureeLegale() {
		return dureeLegale;
	}
	public void setDureeLegale(int dureeLegale) {
		this.dureeLegale = dureeLegale;
	}
	public String getDureeConv() {
		return dureeConv;
	}
	public void setDureeConv(String dureeConv) {
		this.dureeConv = dureeConv;
	}
	public Produit getProduitDossier() {
		return produitDossier;
	}
	public void setProduitDossier(Produit produitDossier) {
		this.produitDossier = produitDossier;
	}
	public Boite getBoiteDossier() {
		return boiteDossier;
	}
	public void setBoiteDossier(Boite boiteDossier) {
		this.boiteDossier = boiteDossier;
	}

	public Users getUserDossier() {
		return userDossier;
	}
	public void setUserDossier(Users userDossier) {
		this.userDossier = userDossier;
	}
	public Mouvement getMvmntDossier() {
		return mvmntDossier;
	}
	public void setMvmntDossier(Mouvement mvmntDossier) {
		this.mvmntDossier = mvmntDossier;
	}

}
