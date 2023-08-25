package br.com.uc9sa4.sa4.service;


import java.util.List;


import br.com.uc9sa4.sa4.models.Livro;

public interface LivroService {
	public List<Livro> listarLivros();
	
	public void apagarLivro(Integer id);
	
	public Livro salvarLivro(Livro livro);
	
	public Livro consultarLivroId(Integer id);
	
	public Livro atualizarLivro(Livro livro);
}