package com.escola.pay.model;

import java.io.Serializable;
import java.util.Date;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sis_aula")
@EqualsAndHashCode(callSuper = false)
public class Aula extends Audit implements Serializable {

	private static final long serialVersionUID = 3770128203923269991L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAula;

	@ManyToOne
	@JoinColumn(name = "cd_turma")
	private Turma turma;

	@ManyToOne
	@JoinColumn(name = "cd_professor")
	private Professor professor;

	@ManyToOne
	@JoinColumn(name = "cd_materia")
	private Materia materia;

	@Column(name = "dt_aula")
	private Date data;

	@Column(name = "hr_aula")
	private String horario;
}
