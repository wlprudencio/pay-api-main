package com.escola.pay.dtos;

import jakarta.validation.constraints.NotBlank;

public record EnderecoPDTO(@NotBlank(message = "O campo 'CEP' não pode ser nulo ou vazio.") String cep,
		String logradouro, String complemento, int numero, String bairro, String localidade) {

}
