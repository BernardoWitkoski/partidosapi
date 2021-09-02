package br.com.partidosapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.partidosapi.constants.Ideologia;
import br.com.partidosapi.dto.AssociadoDTO;
import br.com.partidosapi.dto.PartidoDTO;
import br.com.partidosapi.dto.PartidoFormDTO;


public interface PartidoService {

	//post
	PartidoDTO save(PartidoFormDTO body);
	
	//get all
	Page<PartidoDTO> findAll(Pageable page);
	
	//get by id
	PartidoDTO search(Long id);
	
	//get by ideologia
	//PartidoDTO searchIdeologia(Ideologia ideologia);
	
	//update
	PartidoDTO update(Long id, PartidoFormDTO body);
	
	//delete
	void delete(Long id);
	
}
