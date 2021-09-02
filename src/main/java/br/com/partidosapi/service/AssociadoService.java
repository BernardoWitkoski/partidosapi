package br.com.partidosapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.partidosapi.dto.AssociadoDTO;
import br.com.partidosapi.dto.AssociadoFormDTO;
import br.com.partidosapi.entity.Partido;

public interface AssociadoService {

	//post
	AssociadoDTO save(AssociadoFormDTO body);
	
	//get all
	Page<AssociadoDTO> findAll(Pageable page);
	
	//get by id
	AssociadoDTO search(Long id);

	//update
	AssociadoDTO update(Long id, AssociadoFormDTO body);
	
	AssociadoDTO registerPartido(Long id, Long partido);
	
	//delete
	void delete(Long id);
	
}
