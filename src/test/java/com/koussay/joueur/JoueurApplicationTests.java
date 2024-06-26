package com.koussay.joueur;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.koussay.joueur.entities.Joueur;
import com.koussay.joueur.entities.Position;
import com.koussay.joueur.repos.JoueurRepository;
import com.koussay.joueur.service.JoueurService;

@SpringBootTest
class JoueurApplicationTests {

	@Autowired
	private JoueurRepository jRepository;
	@Autowired
	private JoueurService joueurService;
	/*
	@Test
	public void testCreateJoueur() {
	Joueur prod = new Joueur("messi",2200.500,new Date());
	jRepository.save(prod);
	}*/
	/*
	@Test
	public void testFindJoueur()
	{
	Joueur j = jRepository.findById(1L).get();
	System.out.println(j);
	}*/
	/*
	@Test
	public void testUpdateJoueur()
	{
		Joueur j = jRepository.findById(1L).get();
		j.setPrixJoueur(1000.0);
		jRepository.save(j);
	}
	@Test
	public void testDeleteJoueur()
	{
		jRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousJoueurs()
	{
	List<Joueur> js = jRepository.findAll();
	for (Joueur p : js)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Joueur> prods = joueurService.getAllJoueursParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} 
	}*/
	/*
	@Test
	public void testFindByNomJoueur()
	{
	List<Joueur> j = jRepository.findByNomJoueur("messi");
	for (Joueur p : j)
	{
		System.out.println(p);
	}
	@Test
	public void testFindByNomJoueurContains ()
	{
	List<Joueur> prods=jRepository.findByNomJoueurContains("pe");
	for (Joueur p : prods)
	{
	System.out.println(p);
	} 
	
	@Test
	public void testfindByNomPrix()
	{
	List<Joueur> j = jRepository.findByNomPrix("ronaldo", 2700.0);
	for (Joueur p : j)
	{
		System.out.println(p);
	}
	}
	
	@Test
	public void testfindByPosition()
	{
	Position cat = new Position();
	cat.setIdPos(1L);
	List<Joueur> prods = jRepository.findByPosition(cat);
	for (Joueur p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void findByPositionIdPos()
	{
	List<Joueur> prods = jRepository.findByPositionIdPos(1L);
	for (Joueur p : prods)
	{
	System.out.println(p);
	}
	@Test
	public void testfindByOrderByNomJoueurAsc()
	{
	List<Joueur> prods =jRepository.findByOrderByNomJoueurAsc();
	for (Joueur p : prods)
	{
	System.out.println(p);
	}
	}*/
	@Test
	public void testTrierJoueursNomsPrix()
	{
	List<Joueur> prods = jRepository.trierJoueursNomsPrix();
	for (Joueur p : prods)
	{
	System.out.println(p);
	}
	}
	
	 }


	
	
	
	
	
	
	

	
	





