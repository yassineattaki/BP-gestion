package org.sid.dao;

import java.util.List;

import org.sid.entities.Armoire;
import org.sid.entities.Boite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoiteRepository extends JpaRepository<Boite, Integer>{
	
	/*@Query("select bo from boite bo where bo.armoire.codeArmoire=:x")
	public List<Boite> listeBoiteArmoire(@Param("x")String codeArmoire);*/
	
	
	Boite findByCodeBoite(String codeBoite);
	
	List<Boite> findByArmoire(Long idArmoire);


}
