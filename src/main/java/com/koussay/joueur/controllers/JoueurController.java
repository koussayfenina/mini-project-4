package com.koussay.joueur.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.koussay.joueur.entities.Joueur;
import com.koussay.joueur.entities.Position;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koussay.joueur.service.JoueurService;

import jakarta.validation.Valid;

@Controller
public class JoueurController {
	@Autowired
	JoueurService jService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}

	@RequestMapping("/listeJoueurs")
	public String listeJoueurs(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
		{
			Page<Joueur> prods = jService.getAllJoueursParPage(page, size);
			modelMap.addAttribute("joueurs", prods);
			 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			return "listeJoueurs";
		}
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{	
		List<Position> cats = jService.getAllPositions();
		modelMap.addAttribute("joueur", new Joueur());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("positions", cats);
		return "formJoueur";
	}

	@RequestMapping("/saveJoueur")
	public String saveJoueur(@Valid Joueur joueur,BindingResult bindingResult,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
	{
		int currentPage;
		boolean isNew = false;
	if (bindingResult.hasErrors()) return "formJoueur";
	
	if (joueur.getIdJoueur()==null) 
		isNew=true;
		jService.saveJoueur(joueur);
		if (isNew) //ajout
		{
		Page<Joueur> prods = jService.getAllJoueursParPage(page, size);
		currentPage = prods.getTotalPages()-1;
		}
		else
			
			currentPage=page;
		//return "formJoueur";
		return ("redirect:/listeJoueurs?page="+currentPage+"&size="+size);
	}

	@RequestMapping("/supprimerJoueur")
	public String supprimerJoueur(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
		{
			jService.deleteJoueurById(id);
			Page<Joueur> prods = jService.getAllJoueursParPage(page,size);
					modelMap.addAttribute("joueurs", prods);
					modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
					modelMap.addAttribute("currentPage", page);
					modelMap.addAttribute("size", size);
					return "listeJoueurs";
		}
	@RequestMapping("/modifierJoueur")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size){
		Joueur p = jService.getJoueur(id);
		List<Position> cats = jService.getAllPositions();
		modelMap.addAttribute("joueur", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("positions", cats);
		modelMap.addAttribute("Page", page);
		modelMap.addAttribute("size", size);
		return "formJoueur";
	}

	@RequestMapping("/updateJoueur")
	public String updateProduit(@ModelAttribute("produit") Joueur joueur, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		joueur.setDateCreation(dateCreation);

		jService.updateJoueur(joueur);
		List<Joueur> prods = jService.getAllJoueurs();
		modelMap.addAttribute("Joueurs", prods);
		return "listeJoueurs";
	}
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}
}
