package org.sid.dao;

import java.util.Set;

import org.sid.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,String>{

	Roles findByRole(Set<Roles> roles);
	
	

}
