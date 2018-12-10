package org.sid.dao;

import org.sid.entities.Motif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotifRepository extends JpaRepository<Motif, Integer>{

	Motif findByNomMotif(String nomMotif);
	
}
