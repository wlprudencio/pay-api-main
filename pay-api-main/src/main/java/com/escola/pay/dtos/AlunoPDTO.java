package com.escola.pay.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoPDTO(@NotBlank(message = "O campo 'nome' não pode ser nulo ou vazio.") String nome,

		@NotBlank(message = "O campo 'email' não pode ser nulo ou vazio.") String email,

		@NotBlank(message = "O campo 'telefone' não pode ser nulo ou vazio.") String telefone,

		@NotNull(message = "O campo 'dataNascimento' não pode ser nulo.") @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataNascimento,
		EnderecoPDTO endereco) {

}
