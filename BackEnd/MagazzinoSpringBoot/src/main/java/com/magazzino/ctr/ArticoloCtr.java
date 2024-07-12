package com.magazzino.ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.magazzino.model.Recipes;
import com.magazzino.services.ArticoloService;

@RestController
@RequestMapping("/ricette")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticoloCtr {

	@Autowired
	private ArticoloService articoloS;
	
	@GetMapping
	public List<Recipes> getArticles(){
		return articoloS.getArticles();
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Recipes a){
		articoloS.insert(a);
		return new ResponseEntity<String>("inserimento eseguito",HttpStatus.OK);
	}
/*	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Articolo a){
		articoloS.update(a);
		return new ResponseEntity<String>("update eseguito",HttpStatus.OK);
	}
*/	
	@PutMapping
	public ResponseEntity<String> salvaListaRicette(@RequestBody List<Recipes> ricette) {
	   articoloS.salvaListaRicette(ricette);
	   return new ResponseEntity<String>("update eseguito",HttpStatus.OK);
	}
	/*
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestBody Articolo a){
		articoloS.delete(a);
		return new ResponseEntity<String>("cancellazione eseguita",HttpStatus.OK);
	}
	*/
}
