package com.aulas.entidades;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "livro" , cascade = CascadeType.REMOVE)
	private List<Compra> compras;
	
	@NotBlank(message = "Nome é obrigatório")
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Size(max=4, min=3, message = "O livro deve ter no minimo 3 caracteres")
	private String paginas;
	
	@NotBlank(message = "Gênero é obrigatório")
	@Column(length = 90, nullable = false)
	private String genero;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateAt;
	
	public Instant getCreatedAt() {
		return createdAt;
	}
	@PrePersist
	public void setCreatedAt() {
		this.createdAt = Instant.now();
	}

	public Instant getUpdateAt() {
		return updateAt;
	}
	@PreUpdate
	public void setUpdateAt() {
		this.updateAt = Instant.now();
	}

	public Livro() {
		
	}
	
	public Livro(String nome, String paginas, String genero) {
		this.nome = nome;
		this.paginas = paginas;
		this.genero = genero;
	}

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
	
	
	
	
}
