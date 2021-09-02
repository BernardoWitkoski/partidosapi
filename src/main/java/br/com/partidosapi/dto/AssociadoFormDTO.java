package br.com.partidosapi.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.partidosapi.constants.CargoPolitico;
import br.com.partidosapi.constants.Genero;
import br.com.partidosapi.entity.Partido;
import lombok.Data;

@Data
public class AssociadoFormDTO {

	@NotEmpty(message = "name is required")
	private String nomeAssociado;

	private List<Partido> partido;

	@NotNull(message = "cargoPolitico is required")
	private CargoPolitico cargoPolitico;
	
	@NotNull(message = "anoNascimento is required")
	private int anoNascimento;
	
	@NotNull(message = "genero is required")
	private Genero genero;
	
}
