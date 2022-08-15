package com.aulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.entidades.Livro;
import com.aulas.repository.LivroRepository;

@RestController
@RequestMapping("/")
public class LivroController {
	@Autowired
	LivroRepository repo;
	
	@GetMapping
	public String xpto() {
		return "index de contato";
	}
	
	@GetMapping("/livros")
	public 	ResponseEntity<Iterable<Livro>> getLivros() {
		Iterable<Livro> livros = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(livros);
	}
	
	@GetMapping("/livros/{idlivro}")
	public ResponseEntity<Livro> getLivroById(@PathVariable("idlivro") Long idlivro) {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(idlivro).get());
		
	}
	
	@PostMapping("/livros")
	public ResponseEntity<Livro> saveLivro(@RequestBody Livro livro) {
		Livro lv = repo.save(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(lv);
	}
	
	@DeleteMapping("/livros/{idlivro}")
	public ResponseEntity<Void> deleteLivro(@PathVariable("idlivro") Long idlivro) {
		repo.deleteById(idlivro);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/livros/{idlivro}")
	public ResponseEntity<Livro> alteraLivro(@PathVariable("idlivro") Long idlivro, @RequestBody Livro livro) {
		return ResponseEntity.ok(repo.save(livro));
	}
	

		
}
 