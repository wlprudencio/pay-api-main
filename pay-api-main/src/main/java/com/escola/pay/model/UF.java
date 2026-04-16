package com.escola.pay.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sis_uf")
@EqualsAndHashCode(callSuper = true)
public class UF extends Audit implements Serializable {

	private static final long serialVersionUID = -5510611317292747218L;

	@Id
	@Column(name = "cd_uf")
	private Long id;

	@Column(name = "nm_uf", nullable = false, length = 50)
	private String nome;

	@Column(name = "nm_sigla", nullable = false, length = 2)
	private String sigla;

	@ToString.Exclude
	@JsonBackReference
	@OneToMany(mappedBy = "uf", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
}
