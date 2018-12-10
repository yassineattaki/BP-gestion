package org.sid.dao;

import org.sid.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String>{
	Users findByMatricule(String matricule);

}
