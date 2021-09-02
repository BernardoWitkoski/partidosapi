package br.com.partidosapi.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.partidosapi.constants.Ideologia;
import lombok.Data;

@Data
public class PartidoFormDTO {
	
	@NotEmpty(message = "name is required")
	private String nomePartido;
	
	@NotNull(message = "sigla is required")
	private String sigla;
	
	@NotNull(message = "ideologia is required")
	private Ideologia ideologia;
	
	@NotNull(message = "anoFundacao is required")
	private int anoFundacao;
	
}
