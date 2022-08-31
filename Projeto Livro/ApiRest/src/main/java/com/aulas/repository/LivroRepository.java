package com.aulas.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.entidades.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	List<Livro> findByGenero(String genero);
}
