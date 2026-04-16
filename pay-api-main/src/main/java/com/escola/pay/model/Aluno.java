package com.escola.pay.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.escola.pay.dtos.AlunoUDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "sis_aluno")
@EqualsAndHashCode(callSuper = false)
public class Aluno extends Audit implements Serializable {

	private static final long serialVersionUID = -430336227826965053L;

	@Id
	@Column(name = "cd_aluno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "{aluno.nome.vazio}")
	@Column(name = "nm_aluno")
	private String nome;

	@NotBlank(message = "{aluno.email.vazio}")
	@Column(name = "nm_email")
	private String email;

	@NotNull(message = "{aluno.data.nascimento.nulo}")
	@Column(name = "dt_nascimento")
	private LocalDate dataNascimento;

	@NotBlank(message = "{aluno.telefone.vazio}")
	@Column(name = "no_telefone")
	private String telefone;

	@NotNull(message = "{aluno.endereco.nulo}")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_endereco", referencedColumnName = "cd_endereco")
	private Endereco endereco;

	@OneToMany(mappedBy = "aluno")
	private List<Nota> notas;

	@OneToMany(mappedBy = "aluno")
	private List<Frequencia> frequencias;

	public void update(AlunoUDTO udto) {
		this.nome = Objects.nonNull(udto.nome()) ? udto.nome() : this.nome;
		this.email = Objects.nonNull(udto.email()) ? udto.email() : this.email;
		this.telefone = Objects.nonNull(udto.telefone()) ? udto.telefone() : this.telefone;
		this.dataNascimento = Objects.nonNull(udto.dataNascimento()) ? udto.dataNascimento() : this.dataNascimento;
	}
}
