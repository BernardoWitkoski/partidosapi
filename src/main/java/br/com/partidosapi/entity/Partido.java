package br.com.partidosapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ManyToAny;

import br.com.partidosapi.constants.Ideologia;
import lombok.Data;

@Data
@Entity
@Table(name = "partidos")
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String nomePartido;
	
	@Column(unique = true, nullable = false)
	private String sigla;
	
	@Column(nullable = false)
	private Ideologia ideologia;
	
	@Column(nullable = false)
	private int anoFundacao;
	
	@OneToMany(mappedBy = "partido")
	private List<Associado> associados;

}
