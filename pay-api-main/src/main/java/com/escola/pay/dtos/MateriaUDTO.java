package com.escola.pay.dtos;

import jakarta.validation.constraints.NotNull;

public record MateriaUDTO(@NotNull(message = "O campo 'id' não pode ser nulo") Long id
		, String nome
		, @NotNull(message = "O campo 'id_disciplina não pode ser nulo'") Long idDisciplina) {

}
