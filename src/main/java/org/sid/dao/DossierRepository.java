package org.sid.dao;

import java.util.List;

import org.sid.entities.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DossierRepository extends JpaRepository<Dossier,Integer>{
	
	/*@Query("select doss from dossier doss where doss.mvmntDossier.idMvmnt=:x")
	public List<Dossier> listeDossierMoved(@Param("x")int idMvmnt);
	
	@Query("select doss from dossier doss where doss.boiteDossier.codeBoite=:x")
	public List<Dossier> listeDossierBoite(@Param("x")String codeBoite);*/
	
	
	
	Dossier findByCodeDossier(String codeDossier);

}
