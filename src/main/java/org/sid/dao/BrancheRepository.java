package org.sid.dao;

import org.sid.entities.Branche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrancheRepository extends JpaRepository<Branche,Integer>{
	
	Branche findByCodeBranche(String codeBranche);

}
