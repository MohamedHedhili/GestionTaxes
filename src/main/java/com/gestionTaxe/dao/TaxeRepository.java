package com.gestionTaxe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gestionTaxe.entities.Entreprise;
import com.gestionTaxe.entities.Taxe;

public interface TaxeRepository extends JpaRepository<Taxe, Long>{
public  List<Taxe> findByEntreprise(Entreprise e ); // pour  que Spring data  permet de bien implementer  la  méthode  il faut respecter les conventions de nominations
}
