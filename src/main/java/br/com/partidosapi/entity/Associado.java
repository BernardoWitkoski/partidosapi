package br.com.partidosapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.partidosapi.constants.CargoPolitico;
import br.com.partidosapi.constants.Genero;
import lombok.Data;

@Data
@Entity
@Table(name = "associados")
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = false)
	private String nomeAssociado;
	
	@ManyToMany
	@JoinColumn(name = "id_partido", referencedColumnName = "id", nullable = false)
	private List<Partido> partido;
	
	@Column(nullable = false)
	private CargoPolitico cargoPolitico;
	
	@Column(nullable = false)
	private int anoNascimento;
	
	@Column(nullable = false)
	private Genero genero;
	
}
