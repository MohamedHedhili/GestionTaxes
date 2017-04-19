package com.gestionTaxe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestionTaxe.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
	@Query("select e from Entreprise e  where  e.nom like :m")
public  Page<Entreprise> chercher(@Param("m") String mot ,  Pageable page );
}
