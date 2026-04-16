package com.escola.pay.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.escola.pay.dtos.EnderecoCepDTO;

@FeignClient(contextId = "CepApi", name = "API", url = "https://viacep.com.br/ws")
public interface CepApi {

	@GetMapping("/{cep}/json/")
	EnderecoCepDTO getCep(@PathVariable("cep") String cep);
}
