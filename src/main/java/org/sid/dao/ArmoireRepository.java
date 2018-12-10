package org.sid.dao;

import org.sid.entities.Armoire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmoireRepository extends JpaRepository<Armoire, Long>{
	
	Armoire findByCodeArmoire(String codeArmoire);
	
	
}
