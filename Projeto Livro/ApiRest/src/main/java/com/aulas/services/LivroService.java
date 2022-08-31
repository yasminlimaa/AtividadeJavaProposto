package com.aulas.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.entidades.Livro;
import com.aulas.repository.LivroRepository;
import com.aulas.services.dto.LivroDTO;


@Service
public class LivroService {
	@Autowired
	LivroRepository repo;
	
	public LivroDTO salvar(Livro livro) {
		/*if(livro.getPaginas().length() < 3 ) {
			throw new ValidacaoException("Quantidades de páginas inválida");
		}*/
		
		Livro lv = repo.save(livro);
		LivroDTO livroDTO = new LivroDTO(lv);
		return livroDTO;
	}
	
	public List<LivroDTO> consultarLivros() {
	List<Livro> livros = repo.findAll();
	List<LivroDTO> livrosDTO = new ArrayList();
	for(Livro lv : livros) {
		livrosDTO.add(new LivroDTO(lv));
	}
	return livrosDTO;
	
	}
	
	public LivroDTO consultarLivroPorId(Long idlivro) {
		Optional<Livro> oplivro = repo.findById(idlivro);
		Livro lv = oplivro.orElseThrow( () -> new EntityNotFoundException("Livro não encontrado"));
		return new LivroDTO(lv);
	}
	
	public Livro consultarLivro(Long idlivro) {
		Optional<Livro> oplivro = repo.findById(idlivro);
		Livro lv = oplivro.orElseThrow( () -> new EntityNotFoundException("Livro não encontrado"));
		return lv;
	}
	
	public void excluirLivro(Long idlivro) {
		//Livro lv = consultarLivro(idlivro);
		repo.deleteById(idlivro);
	}
	
	public List<LivroDTO> consultarLivroPorGenero(String genero) {
		return LivroDTO.converteParaDTO(repo.findByGenero(genero));
	}
	
	public LivroDTO alterarLivro(Long idlivro, Livro livro) {
		Livro lv = consultarLivro(idlivro);
		BeanUtils.copyProperties(livro,  lv, "id");
		//lv.setNome(livro.getNome());
		//lv.setPaginas(livro.getPaginas());
		//lv.setGenero(livro.getGenero());
		return new LivroDTO(repo.save(lv));
	}
	
	

}
