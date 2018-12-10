package org.sid.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Mouvement implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMvmnt;
	private Date dateRest;
	private Date dateMvmnt;
	private String numcont;
	private int validation;

	@OneToMany(mappedBy="mvmntDossier",cascade=CascadeType.ALL)
	private List<Dossier> dossierMvmnt;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Users userMvmnt;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Motif motifMvmnt;
	
	
	public Mouvement(Date dateRest, Date dateMvmnt) {
		super();
		this.dateRest = dateRest;
		this.dateMvmnt = dateMvmnt;
	}

	public Mouvement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getValidation() {
		return validation;
	}

	public void setValidation(int validation) {
		this.validation = validation;
	}

	public String getNumcont() {
		return numcont;
	}

	public void setNumcont(String numcont) {
		this.numcont = numcont;
	}
	
	public Date getDateMvmnt() {
		return dateMvmnt;
	}
	public void setDateMvmnt(Date dateMvmnt) {
		this.dateMvmnt = dateMvmnt;
	}
	public void setMotifMvmnt(Motif motifMvmnt) {
		this.motifMvmnt = motifMvmnt;
	}
	
	public int getIdMvmnt() {
		return idMvmnt;
	}
	public void setIdMvmnt(int idMvmnt) {
		this.idMvmnt = idMvmnt;
	}
	public Date getDateRest() {
		return dateRest;
	}
	public void setDateRest(Date dateRest) {
		this.dateRest = dateRest;
	}

	public List<Dossier> getDossierMvmnt() {
		return dossierMvmnt;
	}
	public void setDossierMvmnt(List<Dossier> dossierMvmnt) {
		this.dossierMvmnt = dossierMvmnt;
	}
	
	public Users getUserMvmnt() {
		return userMvmnt;
	}
	public void setUserMvmnt(Users userMvmnt) {
		this.userMvmnt = userMvmnt;
	}
	public Motif getMotifMvmnt() {
		return motifMvmnt;
	}
	
	

}
