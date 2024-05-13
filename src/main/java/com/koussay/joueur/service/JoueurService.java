package com.koussay.joueur.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.koussay.joueur.entities.Joueur;
import com.koussay.joueur.entities.Position;

public interface JoueurService {
	
	Joueur saveJoueur(Joueur p);
	Joueur updateJoueur(Joueur p);
	void deleteJoueur(Joueur p);
	void deleteJoueurById(Long id);
	Joueur getJoueur(Long id);
	List<Joueur> getAllJoueurs();
	Page<Joueur> getAllJoueursParPage(int page, int size);
	
	List<Joueur> findByNomJoueur(String nom);
    List<Joueur> findByNomJoueurContains(String nom);
    List<Joueur> findByNomPrix(String nom, Double prix);
    List<Joueur> findByPosition(Position position); 
    List<Joueur> findByPositionIdPos(Long id);
    List<Joueur> findByOrderByNomJoueurAsc();
    List<Joueur> trierJoueursNomsPrix();
    
    List<Position> getAllPositions();
}


