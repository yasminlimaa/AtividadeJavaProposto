package com.aulas.entidades;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;


@Entity
public class Compra {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank (message = "A livraria deve ser informada")
	private String local;
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	private Livro livro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Compra(@NotBlank(message = "A livraria deve ser informada") String local, Date data, Livro livro) {
		this.local = local;
		this.data = data;
		this.livro = livro;
	}
	
	public Compra() {
		
	}
	
}
