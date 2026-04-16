package com.escola.pay.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.escola.pay.dtos.EnderecoCepDTO;
import com.escola.pay.dtos.EnderecoPDTO;
import com.escola.pay.model.Endereco;
import com.escola.pay.model.UF;
import com.escola.pay.repositoreis.EnderecoRepository;
import com.escola.pay.repositoreis.UfRepository;
import com.escola.pay.service.CepService;
import com.escola.pay.service.EnderecoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

	private final UfRepository ufRepository;
	private final EnderecoRepository repository;
	private final CepService cepService;

	@Override
	public Endereco create(EnderecoPDTO enderecoPDTO) {
		EnderecoCepDTO enderecoCepDTO = this.cepService.findByCep(enderecoPDTO.cep());
		UF uf;
		try {
			uf = this.ufRepository.findBySigla(enderecoCepDTO.uf())
					.orElseThrow(() -> new Exception("UF não encontrado"));
			Endereco endereco = Endereco.builder().bairro(enderecoCepDTO.bairro()).cep(enderecoCepDTO.cep())
					.localidade(enderecoCepDTO.localidade()).logradouro(enderecoCepDTO.logradouro())
					.complemento(Objects.nonNull(enderecoCepDTO.complemento()) ? enderecoCepDTO.complemento() : null)
					.numero(enderecoPDTO.numero()).uf(uf).build();
			return this.repository.save(endereco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
