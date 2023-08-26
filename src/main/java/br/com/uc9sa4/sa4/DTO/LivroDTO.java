package br.com.uc9sa4.sa4.DTO;
import br.com.uc9sa4.sa4.models.Livro;

public class LivroDTO {
	private Long id;
    private String nome;
    private String autor;
    private String editora;
    private Long isbn;
	
    
    
    /**
	 * @param id
	 * @param nome
	 * @param autor
	 * @param editora
	 * @param isbn
	 */
	public LivroDTO(Long id, String nome, String autor, String editora, Long isbn) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.isbn = isbn;
	}
	
	public LivroDTO() {
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
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
}
