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
public class Branche implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBranche;
	 @Column(unique=true)
	private String codeBranche;
	private String nbreBranche;
	
	@OneToMany(mappedBy="brancheUser" ,cascade=CascadeType.ALL)
	private List<Users> userBranche;
	
	
	
	public Branche(String codeBranche, String nbreBranche) {
		super();
		this.codeBranche = codeBranche;
		this.nbreBranche = nbreBranche;
	}
	public Branche() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdBranche() {
		return idBranche;
	}
	public void setIdBranche(int idBranche) {
		this.idBranche = idBranche;
	}
	public String getCodeBranche() {
		return codeBranche;
	}
	public void setCodeBranche(String codeBranche) {
		this.codeBranche = codeBranche;
	}
	public String getNbreBranche() {
		return nbreBranche;
	}
	public void setNbreBranche(String nbreBranche) {
		this.nbreBranche = nbreBranche;
	}
	public List<Users> getUserBranche() {
		return userBranche;
	}
	public void setUserBranche(List<Users> userBranche) {
		this.userBranche = userBranche;
	}


}
