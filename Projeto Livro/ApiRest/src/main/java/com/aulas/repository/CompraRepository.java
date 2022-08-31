package com.aulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aulas.entidades.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
	@Query("select cp from Compra cp, Livro lv where cp.livro = lv.id and lv.nome = ?1")
	List<Compra> consultaComprasPorNomeLivro(String nome);
}
