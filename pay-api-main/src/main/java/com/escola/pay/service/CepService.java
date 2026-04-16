package com.escola.pay.service;

import com.escola.pay.dtos.EnderecoCepDTO;

public interface CepService {

	EnderecoCepDTO findByCep(String cep);

}
