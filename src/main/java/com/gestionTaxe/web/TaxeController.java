package com.gestionTaxe.web;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestionTaxe.dao.EntrepriseRepository;
import com.gestionTaxe.dao.TaxeRepository;
import com.gestionTaxe.entities.Entreprise;
import com.gestionTaxe.entities.Taxe;


@Controller
public class TaxeController {
	@Autowired
	private EntrepriseRepository entrepriseRepo ;
	@Autowired
	private TaxeRepository taxeRepo  ; 
	@RequestMapping(value="entreprises" , method=RequestMethod.GET)
	
public String  index(Model  model ,@RequestParam(name="nom",defaultValue="")String mot  , @RequestParam(name="page",defaultValue="0")int page , @RequestParam(name="size",defaultValue="4") int  size)
{Page<Entreprise> entreprises  =  entrepriseRepo.chercher("%"+mot+"%",new PageRequest(page, size));
model.addAttribute("listEntreprises", entreprises.getContent()) ;
int [] pages =  new int [entreprises.getTotalPages()];
model.addAttribute("page", page);
model.addAttribute("size", size);
model.addAttribute("pages", pages);
model.addAttribute("nom", mot);  //  nom  de lentreprise  qu il  veut  chercher 
return "entreprises";}
	
	@RequestMapping(value="formEntreprise" )
	public String formEntreprise(Model model)

	{ model.addAttribute("entreprise", new Entreprise());

		return "formEntreprise";
	
		}
	
	@RequestMapping(value="addEntreprise" ,  method=RequestMethod.POST)
	public String ajouterEntreprise(Model model,    @Valid Entreprise entreprise ,BindingResult bindingResult)

	{
	if (bindingResult.hasErrors())
		return "formEntreprise";
	entrepriseRepo.save(entreprise) ;
	return "Confirmation";
		}
	@RequestMapping(value="/taxes" ,  method=RequestMethod.GET)
	public String listTaxes (Model model , @RequestParam(name="code" , defaultValue="-1") Long  code )
	{Entreprise e   = new Entreprise();
	e.setCode(code);
	model.addAttribute("entreprises", entrepriseRepo.findAll()) ;
	List<Taxe> listTaxes =  taxeRepo.findByEntreprise(e);
	model.addAttribute("listTaxes",listTaxes);
		return  "taxes";
		
	}
	
	
}
