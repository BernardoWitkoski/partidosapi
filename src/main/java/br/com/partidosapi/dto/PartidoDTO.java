package br.com.partidosapi.dto;

import java.util.List;

import br.com.partidosapi.constants.Ideologia;
import br.com.partidosapi.entity.Associado;
import lombok.Data;

@Data
public class PartidoDTO {

	private Long id;
	
	private String nomePartido;
	
	private String sigla;
	
	private Ideologia ideologia;
	
	private int anoFundacao;
	
	private List<Associado> associados;
	
}
