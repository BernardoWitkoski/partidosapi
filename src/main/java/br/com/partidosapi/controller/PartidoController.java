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

import br.com.partidosapi.constants.Ideologia;
import br.com.partidosapi.dto.PartidoDTO;
import br.com.partidosapi.dto.PartidoFormDTO;
import br.com.partidosapi.service.PartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

	@Autowired
	private PartidoService service;

	@PostMapping
	public ResponseEntity<PartidoDTO> save(@RequestBody @Valid PartidoFormDTO body) {
		PartidoDTO partido = this.service.save(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(partido);
	}
	
	@GetMapping
	public ResponseEntity<Page<PartidoDTO>> findAll(@PageableDefault Pageable page) {
		Page<PartidoDTO> partidos = this.service.findAll(page);
		return ResponseEntity.ok(partidos);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<PartidoDTO> search(@PathVariable Long id) {
		PartidoDTO partido = this.service.search(id);
		return ResponseEntity.ok(partido);
	}
	
	@GetMapping(path = "/{ideologia}")

	
	@PutMapping(path = "/{id}")
	public ResponseEntity<PartidoDTO> update(@PathVariable Long id, @RequestBody @Valid PartidoFormDTO body) {
		PartidoDTO partido = this.service.update(id, body);
		return ResponseEntity.ok(partido);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.service.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	
}
