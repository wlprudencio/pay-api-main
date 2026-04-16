package com.escola.pay.service.impl;

import org.springframework.stereotype.Service;

import com.escola.pay.dtos.EnderecoCepDTO;
import com.escola.pay.http.CepApi;
import com.escola.pay.service.CepService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CepServiceImpl implements CepService {

	private final CepApi api;

	@Override
	public EnderecoCepDTO findByCep(String cep) {
		return this.api.getCep(cep.replace("-", "").trim());
	}

}
