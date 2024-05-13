package com.koussay.joueur.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


@Entity
public class Joueur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idJoueur;

@NotNull
@Size (min = 4,max = 15)
private String nomJoueur;

@Min(value = 100)
@Max(value = 100000000)
private Double prixJoueur;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date dateCreation;

@ManyToOne
private Position position;

public Position getPosition() {
	return position;
}

public void setPosition(Position position) {
	this.position = position;
}

public Joueur() {
super();
}

public Joueur(String nomJoueur, Double prixJoueur, Date dateCreation) {
	super();
	this.nomJoueur = nomJoueur;
	this.prixJoueur = prixJoueur;
	this.dateCreation = dateCreation;
}

public Long getIdJoueur() {
	return idJoueur;
}

public void setIdJoueur(Long idJoueur) {
	this.idJoueur = idJoueur;
}

public String getNomJoueur() {
	return nomJoueur;
}

public void setNomJoueur(String nomJoueur) {
	this.nomJoueur = nomJoueur;
}

public Double getPrixJoueur() {
	return prixJoueur;
}

public void setPrixJoueur(Double prixJoueur) {
	this.prixJoueur = prixJoueur;
}

public Date getDateCreation() {
	return dateCreation;
}

public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}

@Override
public String toString() {
	return "Joueur [idJoueur=" + idJoueur + ", nomJoueur=" + nomJoueur + ", prixJoueur=" + prixJoueur
			+ ", dateCreation=" + dateCreation + "]";
}
}
