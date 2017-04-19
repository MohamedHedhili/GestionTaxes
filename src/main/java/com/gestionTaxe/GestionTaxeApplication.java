package com.gestionTaxe;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestionTaxe.dao.EntrepriseRepository;
import com.gestionTaxe.dao.TaxeRepository;
import com.gestionTaxe.entities.Entreprise;
import com.gestionTaxe.entities.IR;
import com.gestionTaxe.entities.TVA;

@SpringBootApplication
public class GestionTaxeApplication implements CommandLineRunner{
	@Autowired
    private EntrepriseRepository entrepriseRepo ;
	@Autowired
	private TaxeRepository taxeRepo  ;
	public static void main(String[] args) {
		SpringApplication.run(GestionTaxeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Entreprise e  =entrepriseRepo.save(new Entreprise("PIXLEADER", "PIXLEADER@gmail.com","Sarl"));
		//Entreprise e1  =entrepriseRepo.save(new Entreprise("TEKUP", "TEKUP@gmail.com","SARL"));

		
		//taxeRepo.save(new TVA ("TVA sur le voiture ",new Date (),350.000,e ));
		//taxeRepo.save(new IR("R1 ",new Date (),200.000,e1 ));


	}
}
