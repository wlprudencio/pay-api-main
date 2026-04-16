package com.escola.pay.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public record ProfessorUDTO (@NotNull(message = "O campo 'id' não pode ser nulo") Long id, String nome, String email,

		@JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataNascimento, String telefone){

}
