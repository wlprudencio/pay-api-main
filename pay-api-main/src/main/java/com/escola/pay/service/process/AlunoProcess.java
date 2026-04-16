package com.escola.pay.service.process;

import org.springframework.stereotype.Component;

import com.escola.pay.dtos.AlunoRDTO;
import com.escola.pay.exception.BusinessException;
import com.escola.pay.model.Aluno;
import com.escola.pay.repositoreis.AlunoRepository;
import com.escola.pay.utils.StringUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AlunoProcess {

	private final AlunoRepository repository;

	public void alertExistsNome(String nome) {
		if (this.repository.findByNome(nome).isPresent())
			throw new BusinessException(StringUtils.getMensagemValidacao("aluno.nome.existe", nome));
	}

	public Aluno existsById(Long id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new BusinessException(StringUtils.getMensagemValidacao("aluno.nao.encontrado", id)));
	}

	public AlunoRDTO alunoToAlunoRDTO(Aluno aluno) {
		return new AlunoRDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getDataNascimento(),
				aluno.getTelefone());
	}

}
