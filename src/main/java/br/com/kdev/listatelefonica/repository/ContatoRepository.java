package br.com.kdev.listatelefonica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kdev.listatelefonica.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

	@Query("SELECT c, o FROM Contato c JOIN c.operadora o ")
	List<Contato> todosContatos();

}
