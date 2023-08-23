package br.com.uc9sa4.sa4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Livro")
public class Livro {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String autor;
	private double isbn;
	private String editora;
	
	public Livro(int id, String nome, String autor, int isbn, String editora) {
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public double getIsbn() {
		return isbn;
	}
	public void setIsbn(double isbn2) {
		this.isbn = isbn2;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
}
