package br.com.partidosapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.partidosapi.dto.AssociadoDTO;
import br.com.partidosapi.dto.AssociadoFormDTO;
import br.com.partidosapi.service.AssociadoService;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

	@Autowired
	private AssociadoService service;
	
	@PostMapping
	public ResponseEntity<AssociadoDTO> save(@RequestBody @Valid AssociadoFormDTO body) {
		AssociadoDTO associado = this.service.save(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(associado);
	}
	
	@PostMapping(path = "/{id}/partido/{partido}")
	public ResponseEntity<String> registerPartido(@PathVariable("id") Long id, @PathVariable("partido") Long partido) {
		AssociadoDTO associado = this.service.registerPartido(id, partido);
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}

	//GET /associados
		// (TER UMA OPÇÃO DE FILTRAR ASSOCIADOS DE ACORDO COM SEU CARGO POLITICO)
	@GetMapping
	public ResponseEntity<Page<AssociadoDTO>> findAll(@PageableDefault Pageable page) {
		Page<AssociadoDTO> associados = this.service.findAll(page);
		return ResponseEntity.ok(associados);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<AssociadoDTO> search(@PathVariable Long id) {
		AssociadoDTO associado = this.service.search(id);
		return ResponseEntity.ok(associado);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<AssociadoDTO> update(@PathVariable Long id, @RequestBody @Valid AssociadoFormDTO body) {
		AssociadoDTO associado = this.service.update(id, body);
		return ResponseEntity.ok(associado);
	}
	
	//DELETE /associados/{id}/partidos/{id} (REMOVE DETERMINADO ASSOCIADO DAQUELE PARTIDO)
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.service.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	//POST - /associados/partidos (VINCULA UM ASSOCIADO A UM PARTIDO)
	// associados/{id}/partido;

}
