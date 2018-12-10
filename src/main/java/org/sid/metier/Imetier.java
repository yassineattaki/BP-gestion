package org.sid.metier;

import java.util.Map;

import org.sid.entities.Roles;
import org.sid.entities.Users;

public interface Imetier {
	
	public Users findByMatricule(String matricule);
	
	void saveUser(Users user);
	

}
