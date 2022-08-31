package com.aulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.entidades.Compra;
import com.aulas.repository.CompraRepository;

@RestController
@RequestMapping("/")
public class ComprasController {
	@Autowired
	CompraRepository repo;
	
	@GetMapping("/compras/livro/{nome}")
	public ResponseEntity<List<Compra>> consultaCompraPeloNomeLivro(@PathVariable("nome")
	String nome) {
		return ResponseEntity.ok(repo.consultaComprasPorNomeLivro(nome));
	}
	
	@GetMapping("/compras")
	public ResponseEntity<List<Compra>> consultarCompra() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping("/compras")
	public ResponseEntity<Compra> salvarCompra(@RequestBody Compra compra) {
		return ResponseEntity.ok(repo.save(compra));
	}
}
