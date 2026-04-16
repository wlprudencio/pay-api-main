package com.escola.pay.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.escola.pay.dtos.ProfessorUDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "sis_professor")
@EqualsAndHashCode(callSuper = false)
public class Professor extends Audit implements Serializable {

	private static final long serialVersionUID = 530580638188060626L;

	@Id
	@Column(name = "cd_professor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "{professor.nome.vazio}")
	@Column(name = "nm_professor")
	private String nome;

	@NotBlank(message = "{professor.especialidade.vazio}")
	@Column(name = "ne_especialidade")
	private String especialidade;

	@NotBlank(message = "{professor.data.nascimento.nulo}")
	@Column(name = "dt_nascimento")
	private LocalDate dataNascimento;

	@NotNull(message = "{professor.endereco.nulo}")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_endereco", referencedColumnName = "cd_endereco")
	private Endereco endereco;

	@NotBlank(message = "{professor.telefone.vazio}")
	@Column(name = "no_telefone")
	private String telefone;

	@NotBlank(message = "{professor.email.vazio}")
	@Column(name = "nm_email")
	private String email;

	public void update(ProfessorUDTO udto) {
		this.nome = Objects.nonNull(udto.nome()) ? udto.nome() : this.nome;
		this.email = Objects.nonNull(udto.email()) ? udto.email() : this.email;
		this.telefone = Objects.nonNull(udto.telefone()) ? udto.telefone() : this.telefone;
		this.dataNascimento = Objects.nonNull(udto.dataNascimento()) ? udto.dataNascimento() : this.dataNascimento;
	}

}
