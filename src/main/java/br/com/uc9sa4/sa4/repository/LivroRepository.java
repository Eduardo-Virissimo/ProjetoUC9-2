package br.com.uc9sa4.sa4.repository;

import br.com.uc9sa4.sa4.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> { 
	
	Iterable<Livro> findById(int id);
	Iterable<Livro> findByNome(String nome);
	Iterable<Livro> findByAutor(String autor);
    Iterable<Livro> findByEditora(String editora);
    Iterable<Livro> findByIsbn(double isbn);


}

