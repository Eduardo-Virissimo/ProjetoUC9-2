package br.com.uc9sa4.sa4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Livros")
public class Livro {
	@Id
//	@GeneratedValue
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String autor;
	private Long isbn;
	private String editora;
	
	public Livro(Long id, String nome, String autor, Long isbn, String editora) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.isbn = isbn;
		this.editora = editora;
	}
	public Livro() {
		super();
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
}
