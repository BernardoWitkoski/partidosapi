package br.com.partidosapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.partidosapi.constants.Ideologia;
import br.com.partidosapi.dto.PartidoDTO;
import br.com.partidosapi.dto.PartidoFormDTO;
import br.com.partidosapi.entity.Partido;
import br.com.partidosapi.exceptions.BusinessException;
import br.com.partidosapi.repository.PartidoRepository;

@Service
public class PartidoServiceImpl implements PartidoService {

	@Autowired
	private PartidoRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public PartidoDTO save(PartidoFormDTO body) {
		Partido partido = this.repository.save(mapper.map(body, Partido.class));
		return mapper.map(partido, PartidoDTO.class);
	}
	
	@Override
	public Page<PartidoDTO> findAll(Pageable page) {
		Page<Partido> partidos = this.repository.findAll(page);
		List<PartidoDTO> listPartidos = partidos.getContent()
				.stream()
				.map(partido -> mapper.map(partido, PartidoDTO.class))
				.collect(Collectors.toList());
		return new PageImpl<PartidoDTO>(listPartidos, page, partidos.getTotalElements());
	}
	
	@Override
	public PartidoDTO search(Long id) {
		Partido partido = this.repository.findById(id)
				.orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Partido not found"));
		return mapper.map(partido, PartidoDTO.class);
	}
	
	
	@Override
	public PartidoDTO update(Long id, PartidoFormDTO body) {
		Partido partido = this.repository.findById(id)
				.orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Partido not found"));
		partido.setNomePartido(body.getNomePartido());
		partido.setSigla(body.getSigla());
		partido.setIdeologia(body.getIdeologia());
		partido.setAnoFundacao(body.getAnoFundacao());
		Partido updated = this.repository.save(partido);
		return mapper.map(updated, PartidoDTO.class);
	}
	
	@Override
	public void delete(Long id) {
		try {
			Partido partido = this.repository.findById(id)
					.orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Partido not found"));
			this.repository.delete(partido);
		} catch (Exception ex) {
			throw new BusinessException(409, "CONFLICT", "Delete associadow from the partido");
		}
	}
	
	
	
}
