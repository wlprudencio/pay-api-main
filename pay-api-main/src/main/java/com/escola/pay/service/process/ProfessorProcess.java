package com.escola.pay.service.process;

import org.springframework.stereotype.Component;

import com.escola.pay.dtos.ProfessorRDTO;
import com.escola.pay.exception.BusinessException;
import com.escola.pay.model.Professor;
import com.escola.pay.repositoreis.ProfessorRepository;
import com.escola.pay.utils.StringUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProfessorProcess {

	private final ProfessorRepository repository;

	public void alertExistsNome(String nome) {
		if (this.repository.findByNome(nome).isPresent())
			throw new BusinessException(StringUtils.getMensagemValidacao("professor.nome.existe", nome));
	}

	public Professor existsById(Long id) {
		return this.repository.findById(id).orElseThrow(
				() -> new BusinessException(StringUtils.getMensagemValidacao("professor.nao.encontrado", id)));
	}

	public ProfessorRDTO professorToProfessorRDTO(Professor professor) {
		return new ProfessorRDTO(professor.getId(), professor.getNome(), professor.getEmail(),
				professor.getDataNascimento(), professor.getTelefone());
	}

}
