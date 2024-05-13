package com.koussay.joueur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.koussay.joueur.entities.Joueur;
import com.koussay.joueur.entities.Position;
import com.koussay.joueur.repos.JoueurRepository;
import com.koussay.joueur.repos.PositionRepository;


@Service
public class JoueurServiceImpl implements JoueurService {
	
	
	@Autowired
	JoueurRepository jRepository;
	
	@Autowired
	PositionRepository pRepository;

	@Override
	public Joueur saveJoueur(Joueur p) {
		return jRepository.save(p);
	}

	@Override
	public Joueur updateJoueur(Joueur p) {
		return jRepository.save(p);
	}

	@Override
	public void deleteJoueur(Joueur p) {
		jRepository.delete(p);

		
	}

	@Override
	public void deleteJoueurById(Long id) {
		jRepository.deleteById(id);
	}

	@Override
	public Joueur getJoueur(Long id) {
		return jRepository.findById(id).get();

	}

	@Override
	public List<Joueur> getAllJoueurs() {
		return jRepository.findAll();
	}

	@Override
	public Page<Joueur> getAllJoueursParPage(int page, int size) {
		return jRepository.findAll(PageRequest.of(page, size));
	}

	@Override
    public List<Joueur> findByNomJoueur(String nom) {
        return jRepository.findByNomJoueur(nom);
    }

    @Override
    public List<Joueur> findByNomJoueurContains(String nom) {
        return jRepository.findByNomJoueurContains(nom);
    }

    @Override
    public List<Joueur> findByNomPrix(String nom, Double prix) {
        return jRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Joueur> findByPosition(Position position) {
        return jRepository.findByPosition(position);
    }

    @Override
    public List<Joueur> findByPositionIdPos(Long id) {
        return jRepository.findByPositionIdPos(id);
    }

    @Override
    public List<Joueur> findByOrderByNomJoueurAsc() {
        return jRepository.findByOrderByNomJoueurAsc();
    }

    @Override
    public List<Joueur> trierJoueursNomsPrix() {
        return jRepository.trierJoueursNomsPrix();
    }

	@Override
	public List<Position> getAllPositions() {
		return pRepository.findAll();
	}

}
