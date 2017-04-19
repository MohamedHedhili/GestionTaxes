package com.gestionTaxe.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE" ,  discriminatorType=DiscriminatorType.STRING , length=3)
public class Taxe  implements Serializable {
@Id @GeneratedValue
private Long  id  ;  
private String titre  ; 
private Date  dateTaxe   ;
private  Double Montant  ;
@ManyToOne
@JoinColumn(name="code_entreprise")
private Entreprise  entreprise  ;

public Taxe() {
	super();
	// TODO Auto-generated constructor stub
}
public Taxe(String titre, Date dateTaxe, Double montant, Entreprise entreprise) {
	super();
	this.titre = titre;
	this.dateTaxe = dateTaxe;
	Montant = montant;
	this.entreprise = entreprise;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public Date getDateTaxe() {
	return dateTaxe;
}
public void setDateTaxe(Date dateTaxe) {
	this.dateTaxe = dateTaxe;
}
public Double getMontant() {
	return Montant;
}
public void setMontant(Double montant) {
	Montant = montant;
}
public Entreprise getEntreprise() {
	return entreprise;
}
public void setEntreprise(Entreprise entreprise) {
	this.entreprise = entreprise;
} 


}
