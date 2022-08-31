package com.aulas.services.dto;

import java.util.ArrayList;
import java.util.List;

import com.aulas.entidades.Livro;

public class LivroDTO {
	private Long id;
	private String nome;
	private String paginas;
	private String genero;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public LivroDTO(Long id, String nome, String paginas, String genero) {
		this.id = id;
		this.nome = nome;
		this.paginas = paginas;
		this.genero = genero;
	}
	
	public LivroDTO( ) {
		
	}
	
	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.nome = livro.getNome();
		this.paginas = livro.getPaginas();
		this.genero = livro.getGenero();
	}
	
	public static List<LivroDTO> converteParaDTO(List<Livro> livros) {
		List<LivroDTO> livrosDTO = new ArrayList<>();
		for(Livro lv : livros) {
			livrosDTO.add(new LivroDTO(lv));
		}
		return livrosDTO;
	}
	
}

	
