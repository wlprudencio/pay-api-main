package com.escola.pay.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sis_disciplina")
@EqualsAndHashCode(callSuper = true)
public class Disciplina extends Audit implements Serializable {

	private static final long serialVersionUID = -6530801064273902563L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_disciplina")
	private Long id;

	@NotBlank(message = "{disciplina.nome.vazio}")
	@Column(name = "nm_disciplina")
	private String nome;

	@NotNull(message = "disciplina.cargaHoraria.vazio")
	@Column(name = "cg_horaria")
	private int cargaHoraria;

	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY)
	private List<Materia> materias;

}

//ID_Disciplina (chave primária)
//Nome
//Carga_Horária