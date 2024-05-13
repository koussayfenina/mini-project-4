package com.koussay.joueur.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koussay.joueur.entities.Joueur;
import com.koussay.joueur.service.JoueurService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JoueurRESTController {
	
	@Autowired
	JoueurService jService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Joueur> getAllJoueurs() {
	return jService.getAllJoueurs();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Joueur getJoueurById(@PathVariable("id") Long id) {
		return jService.getJoueur(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Joueur createJoueur(@RequestBody Joueur j) {
		return jService.saveJoueur(j);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Joueur updateJoueur(@RequestBody Joueur j) {
		return jService.updateJoueur(j);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteJoueur(@PathVariable("id") Long id)
	{
		jService.deleteJoueurById(id);
	}
	
	@RequestMapping(value="/jpos/{idPos}",method = RequestMethod.GET)
	public List<Joueur> getJoueursByCatId(@PathVariable("idPos") Long idPos) {
		return jService.findByPositionIdPos(idPos);
	}


}
