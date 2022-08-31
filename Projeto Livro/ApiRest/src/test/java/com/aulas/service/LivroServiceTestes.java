package com.aulas.service;

import java.util.Optional;


import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aulas.entidades.Livro;
import com.aulas.repository.LivroRepository;
import com.aulas.services.LivroService;
import com.aulas.services.dto.LivroDTO;

@ExtendWith(SpringExtension.class)
public class LivroServiceTestes {
	private Long idExistente;
	private Long idNaoExistente;
	private Livro livroValido;
	private Livro livroInvalido;
	
	@BeforeEach
	void setup() {
		idExistente = 1l;
		idNaoExistente = 1000l;	
		livroValido = new Livro("novembro 9", "300", "romance");
		livroValido = new Livro("novembro 9", "350", "romance");
		
		Mockito.doThrow(IllegalArgumentException.class).when(repository).save(livroInvalido);
		Mockito.when(repository.save(livroValido)).thenReturn(livroValido);
		
		Mockito.doNothing().when(repository).deleteById(idExistente);
		Mockito.doThrow(EntityNotFoundException.class).when(repository).deleteById(idNaoExistente);
		
		Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(new Livro()));
		Mockito.doThrow(EntityNotFoundException.class).when(repository).findById(idNaoExistente);
	}

	@InjectMocks
	LivroService service;
	
	@Mock
	LivroRepository repository;
	
	
	public void retornaExcecaoQuandoSalvarSemSucesso() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.salvar(livroInvalido));
		Mockito.verify(repository).save(livroValido);
	}
	
	
	public void retornaLivroDTOQuandoSalvarComSucesso() {
		LivroDTO livroDTO = service.salvar(livroValido);
		Assertions.assertNotNull(livroDTO);
		Mockito.verify(repository).save(livroValido);
	}
	
	
	public void retornaNadaAoExcluirComIdExistente() {
		Livro lv = service.consultarLivro(idExistente);
		Assertions.assertNotNull(lv);
		Mockito.verify(repository).findById(idExistente);
	}
	
	
	public void retornaLivroQuandoPesquisaPorIdExistente() {
		Livro lv = service.consultarLivro(idExistente);
		Assertions.assertNotNull(lv);
		Mockito.verify(repository).findById(idExistente);
	}
	
	
	public void lancaEntidadeNaoEncontradaAoExcluirIdNaoExistente() {
		Assertions.assertThrows(EntityNotFoundException.class, () -> {
			service.excluirLivro(idNaoExistente);
		});
		Mockito.verify(repository,Mockito.times(1)).deleteById(idNaoExistente);
	}
	
	
	public void lancaEntidadeNaoEncontradaAoConsultarIdNaoExistente() {
		Assertions.assertThrows(EntityNotFoundException.class, () -> {
			service.consultarLivroPorId(idNaoExistente);
		});
		Mockito.verify(repository,Mockito.times(1)).findById(idNaoExistente);
	}
}
