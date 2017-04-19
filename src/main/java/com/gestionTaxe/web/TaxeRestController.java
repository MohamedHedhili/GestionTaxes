package com.gestionTaxe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestionTaxe.dao.EntrepriseRepository;
import com.gestionTaxe.dao.TaxeRepository;
import com.gestionTaxe.entities.Entreprise;
import com.gestionTaxe.entities.Taxe;

@RestController
public class TaxeRestController {
	@Autowired
private EntrepriseRepository entrepriseRepo  ;
	@Autowired
	private TaxeRepository taxeRepo  ;
@RequestMapping("/ListEntreprises")
public Page<Entreprise> findEntreprises (@RequestParam(name="nom" ,defaultValue="")String  nom ,
		@RequestParam(name="page" ,defaultValue="0")int page ,
		@RequestParam(name="size" ,defaultValue="4")int size)
{return  entrepriseRepo.chercher("%"+nom+"%", new PageRequest(page, size));}
@RequestMapping("/ListTaxes")
public  List<Taxe> findTaxes()
{return  taxeRepo.findAll();}
}
