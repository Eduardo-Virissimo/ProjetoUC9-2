package br.com.uc9sa4.sa4.repository;

import br.com.uc9sa4.sa4.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> { 
	
	Iterable<Livro> findById(int id);
	
}

