package com.escola.pay.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.pay.dtos.EnderecoCepDTO;
import com.escola.pay.service.CepService;
import com.escola.pay.utils.Response;

import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("/cep")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CepController {

	private final CepService service;

	@GetMapping("/{cep}")
	public ResponseEntity<Response<EnderecoCepDTO>> findByCep(@PathVariable String cep) {
		Response<EnderecoCepDTO> response = new Response<>();
		EnderecoCepDTO dto = this.service.findByCep(cep);
		response.setData(dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
