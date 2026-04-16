package com.escola.pay.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.escola.pay.dtos.MateriaUDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "sis_materia")
@EqualsAndHashCode(callSuper = false)
public class Materia extends Audit implements Serializable{

	private static final long serialVersionUID = -1530453177788132551L;

	@Id
	@Column(name = "cd_materia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "{materia.nome.vazio}")
	@Column(name = "nm_materia")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "cd_disciplina", referencedColumnName = "cd_disciplina")
	private Disciplina disciplina;

	@OneToMany(mappedBy = "materia")
	private List<Nota> notas;

	public void update(MateriaUDTO udto) {
		this.nome = Objects.nonNull(udto.nome()) ? udto.nome() : this.nome;
	}

}
