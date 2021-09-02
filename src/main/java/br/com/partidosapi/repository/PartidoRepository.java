package br.com.partidosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.partidosapi.entity.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long>{

}
