package com.escola.pay.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record AlunoRDTO(Long id, String nome, String email,

		@JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataNascimento, String telefone) {

}
