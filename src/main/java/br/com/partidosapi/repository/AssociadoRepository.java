package br.com.partidosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.partidosapi.entity.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>{
	
}
