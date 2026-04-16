package com.escola.pay.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sis_nota")
@EqualsAndHashCode(callSuper=false)
public class Nota extends Audit implements Serializable{

	private static final long serialVersionUID = -3506882461817151338L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_nota")
	private Long id;

	@NotNull(message = "ID do aluno não pode ser nulo.")
	@ManyToOne
	@JoinColumn(name = "cd_aluno")
	private Aluno aluno;

	@NotNull(message = "ID da matéria não pode ser nulo.")
	@ManyToOne
	@JoinColumn(name = "cd_materia")
	private Materia materia;

	@NotNull(message = "Nota não pode ser nula.")
	@Column(name = "vl_nota")
	private double valorNota;

	@NotNull(message = "Data não pode ser nula.")
	@Column(name = "dt_nota")
	private LocalDate data;

}
