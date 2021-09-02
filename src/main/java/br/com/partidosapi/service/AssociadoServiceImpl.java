package br.com.partidosapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.partidosapi.dto.AssociadoDTO;
import br.com.partidosapi.dto.AssociadoFormDTO;
import br.com.partidosapi.entity.Associado;
import br.com.partidosapi.entity.Partido;
import br.com.partidosapi.exceptions.BusinessException;
import br.com.partidosapi.repository.AssociadoRepository;
import br.com.partidosapi.repository.PartidoRepository;

@Service
public class AssociadoServiceImpl implements AssociadoService {

	@Autowired
	private AssociadoRepository repository;
	@Autowired
	private PartidoRepository partidoRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public AssociadoDTO save(AssociadoFormDTO body) {
		Associado associado = this.repository.save(mapper.map(body, Associado.class));
		return mapper.map(associado, AssociadoDTO.class);
	}
	
	@Override
	public AssociadoDTO registerPartido(Long id, Long partido) {
		Associado associado = this.repository.findById(id)
				.orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
		Partido partidoFind = this.partidoRepository.findById(partido)
			.orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
		List<Partido> partidoLista = new ArrayList<Partido>();
		partidoLista.add(partidoFind);
		associado.setPartido(partidoLista);
		associado = this.repository.save(associado);
		return mapper.map(associado, AssociadoDTO.class);
	}
	
	@Override
	public Page<AssociadoDTO> findAll(Pageable page) {
		Page<Associado> associados = this.repository.findAll(page);
		List<AssociadoDTO> listAssociados = associados.getContent()
				.stream()
				.map(associado -> mapper.map(associado, AssociadoDTO.class))
				.collect(Collectors.toList());
		return new PageImpl<AssociadoDTO>(listAssociados, page, associados.getTotalElements());
	}
	
	@Override
	public AssociadoDTO search(Long id) {
		Associado associado = this.repository.findById(id)
				.orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
		return mapper.map(associado, AssociadoDTO.class);
	}
	
	@Override
	public AssociadoDTO update(Long id, AssociadoFormDTO body) {
		Associado associado = this.repository.findById(id)
				.orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
		associado.setNomeAssociado(body.getNomeAssociado());
		associado.setGenero(body.getGenero());
		associado.setAnoNascimento(body.getAnoNascimento());
		associado.setCargoPolitico(body.getCargoPolitico());
		Associado updated = this.repository.save(associado);
		return mapper.map(updated, AssociadoDTO.class);
	}
	
	@Override
	public void delete(Long id) {
		try {
			Associado associado = this.repository.findById(id)
					.orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
			this.repository.delete(associado);
		} catch (Exception ex) {
			throw new BusinessException(409, "CONFLICT", "Delete associado from his partido");
		}
	}
	
}
