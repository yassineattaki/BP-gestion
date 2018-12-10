package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;



@Entity
public class Users implements Serializable{
	 /*@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;*/
	 @Id
	 @Column(unique=true) 
	private String matricule;
	 @NotNull
	private String password;
	private int active;
	@NotNull
	private String nomUser;
	@NotNull
	private String prenomUser;
	@NotNull
	private String adresseUser;
	@NotNull
	private String sexeUser;
	@NotNull
	@Column(unique=true)
	private String cinUser;
	
	@OneToMany(mappedBy="userDossier",cascade=CascadeType.ALL)
	private List<Dossier> dossierUser;
	
	@OneToMany(mappedBy="userMvmnt",cascade=CascadeType.ALL)
	private List<Mouvement> mvmntUser;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Branche brancheUser;
	
	@ManyToMany
	@JoinTable(name = "USERS_ROLES")
	private Set<Roles> roles;

	
	
	public Users(String matricule, @NotNull String password, @NotNull String nomUser, @NotNull String prenomUser,
			@NotNull String adresseUser, @NotNull String sexeUser, @NotNull String cinUser) {
		super();
		this.matricule = matricule;
		this.password = password;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.adresseUser = adresseUser;
		this.sexeUser = sexeUser;
		this.cinUser = cinUser;
	}

	public Users(String matricule, String password, int active, String nomUser, String prenomUser,
			String adresseUser, String sexeUser, String cinUser) {
		super();
		this.matricule = matricule;
		this.password = password;
		this.active = active;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.adresseUser = adresseUser;
		this.sexeUser = sexeUser;
		this.cinUser = cinUser;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public String getAdresseUser() {
		return adresseUser;
	}
	public void setAdresseUser(String adresseUser) {
		this.adresseUser = adresseUser;
	}
	public String getSexeUser() {
		return sexeUser;
	}
	public void setSexeUser(String sexeUser) {
		this.sexeUser = sexeUser;
	}
	public String getCinUser() {
		return cinUser;
	}
	public void setCinUser(String cinUser) {
		this.cinUser = cinUser;
	}


	public List<Dossier> getDossierUser() {
		return dossierUser;
	}

	public void setDossierUser(List<Dossier> dossierUser) {
		this.dossierUser = dossierUser;
	}

	public List<Mouvement> getMvmntUser() {
		return mvmntUser;
	}

	public void setMvmntUser(List<Mouvement> mvmntUser) {
		this.mvmntUser = mvmntUser;
	}

	public Branche getBrancheUser() {
		return brancheUser;
	}

	public void setBrancheUser(Branche brancheUser) {
		this.brancheUser = brancheUser;
	}

	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public int getColumnCount() {

        return getClass().getDeclaredFields().length;
    }

}
