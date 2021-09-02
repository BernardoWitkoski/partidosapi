package br.com.partidosapi.dto;

import java.util.List;

import br.com.partidosapi.constants.CargoPolitico;
import br.com.partidosapi.constants.Genero;
import br.com.partidosapi.entity.Partido;
import lombok.Data;

@Data
public class AssociadoDTO {

	private Long id;
	
	private String nomeAssociado;
	
	private List<Partido> partido;
	
	private CargoPolitico cargoPolitico;
	
	private int anoNascimento;
	
	private Genero genero;
	
}
