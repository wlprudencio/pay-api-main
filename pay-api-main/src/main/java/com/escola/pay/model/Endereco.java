package com.escola.pay.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sis_endereco")
@EqualsAndHashCode(callSuper = true)
public class Endereco extends Audit implements Serializable{

	private static final long serialVersionUID = -4091357269751389968L;

	@Id
	@Column(name = "cd_endereco")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "no_cep")
	private String cep;

	@Column(name = "nm_logradouro")
	private String logradouro;

	@Column(name = "nm_complemento")
	private String complemento;

	@Column(name = "no_numero")
	private int numero;

	@Column(name = "nm_bairro")
	private String bairro;

	@Column(name = "nm_localidade")
	private String localidade;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "cd_uf")
	private UF uf;
	
	@OneToOne(mappedBy = "endereco")
	private Aluno aluno;

}
