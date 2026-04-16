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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sis_frequencia")
@EqualsAndHashCode(callSuper = false)
public class Frequencia extends Audit implements Serializable {

	private static final long serialVersionUID = 228052485065164675L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFrequencia;

	@ManyToOne
	@JoinColumn(name = "cd_aluno", nullable = false)
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "cd_turma", nullable = false)
	private Turma turma;

	@Column(name = "dt_frenquncia", nullable = false)
	private LocalDate data;

	@Column(name = "is_presenca", nullable = false)
	private Boolean presenca;

}