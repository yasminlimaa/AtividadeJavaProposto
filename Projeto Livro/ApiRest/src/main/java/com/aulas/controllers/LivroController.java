package com.aulas.controllers;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.entidades.Livro;
import com.aulas.services.LivroService;
import com.aulas.services.dto.LivroDTO;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class LivroController {
	@Autowired
	LivroService service;
	
	@GetMapping
	public String xpto() {
		return "index de livros";
	}
	
	@GetMapping("/livros/genero/{genero}")
	public ResponseEntity<List<LivroDTO>> getLivrosPorEmail(@PathVariable("genero") String genero) {
		return ResponseEntity.ok(service.consultarLivroPorGenero(genero));
	}
	
	@GetMapping("/livros")
	public 	ResponseEntity<List<LivroDTO>> getLivros() {
		List<LivroDTO> livros = service.consultarLivros();
		return ResponseEntity.status(HttpStatus.OK).body(livros);
	}
	
	@GetMapping("/livros/{idlivro}")
	public ResponseEntity<LivroDTO> getLivroById(@PathVariable("idlivro") Long idlivro) {
		return ResponseEntity.ok(service.consultarLivroPorId(idlivro));
		
	}
	
	@PostMapping("/livros")
	public ResponseEntity<LivroDTO> saveLivro(@Valid @RequestBody Livro livro) {
		LivroDTO lv = service.salvar(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(lv);
	}
	
	@DeleteMapping("/livros/{idlivro}")
	public ResponseEntity<Void> deleteLivro(@PathVariable("idlivro") Long idlivro) {
		service.excluirLivro(idlivro);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/livros/{idlivro}")
	public ResponseEntity<LivroDTO> alteraLivro(@PathVariable("idlivro") Long idlivro, 
			@RequestBody Livro livro) {
		
		return ResponseEntity.ok(service.alterarLivro(idlivro,livro));
	}
	

		
}
 