package com.magazzino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magazzino.model.Recipes;
import com.magazzino.repository.ArticoloRepository;

@Service
public class ArticoloService {

	@Autowired
	private ArticoloRepository articoloR;
	
	public List<Recipes> getArticles(){
		
		return articoloR.findAll();
	}
	
	public void insert(Recipes a) {
		articoloR.save(a);
	}
	
	public void update(Recipes a) {
		articoloR.save(a);
	}
	
	@Transactional
	public void salvaListaRicette(List<Recipes> ricette) {
	    for (Recipes ricetta : ricette) {
	        try {
	            articoloR.save(ricetta);
	        } catch (Exception e) {
	            // Gestisci l'errore (ad esempio, registra l'errore e lancia un'eccezione appropriata)
	            throw new RuntimeException("Errore durante il salvataggio dell'articolo: " + e.getMessage());
	        }
	    }
	}
	/*public void delete(Articolo a) {
		articoloR.deleteById(a.getCodart());
	}*/
}
