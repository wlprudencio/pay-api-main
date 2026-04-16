package com.escola.pay.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "turma")
@EqualsAndHashCode(callSuper = false)
public class Turma extends Audit implements Serializable {

	private static final long serialVersionUID = -8851568379299169361L;

	@Id
	@Column(name = "cd_turma")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTurma;

	@Column(name = "nome", nullable = false)
	private String nome;

	// Relação com a classe Frequencia
	@OneToMany(mappedBy = "turma")
	private List<Frequencia> frequencias;

}
