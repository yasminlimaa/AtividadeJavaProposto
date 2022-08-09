package com.aulas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aulas.entidades.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer>{

}
