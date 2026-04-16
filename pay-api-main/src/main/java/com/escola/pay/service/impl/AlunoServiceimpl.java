package com.escola.pay.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.escola.pay.dtos.AlunoPDTO;
import com.escola.pay.dtos.AlunoRDTO;
import com.escola.pay.dtos.AlunoUDTO;
import com.escola.pay.model.Aluno;
import com.escola.pay.model.Endereco;
import com.escola.pay.repositoreis.AlunoRepository;
import com.escola.pay.service.AlunoService;
import com.escola.pay.service.EnderecoService;
import com.escola.pay.service.process.AlunoProcess;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoServiceimpl implements AlunoService {

	private final AlunoRepository repository;
	private final EnderecoService enderecoService;
	private final AlunoProcess alunoProcess;

	@Override
	public AlunoRDTO create(AlunoPDTO alunoPDTO) {
		this.alunoProcess.alertExistsNome(alunoPDTO.nome());
		Endereco endereco = this.enderecoService.create(alunoPDTO.endereco());
		Aluno aluno = Aluno.builder().nome(alunoPDTO.nome()).email(alunoPDTO.email()).telefone(alunoPDTO.telefone())
				.endereco(endereco).dataNascimento(alunoPDTO.dataNascimento()).build();
		aluno = this.repository.save(aluno);

		return this.alunoProcess.alunoToAlunoRDTO(aluno);
	}

	@Override
	public AlunoRDTO findById(Long id) {
		Aluno aluno = this.alunoProcess.existsById(id);
		return this.alunoProcess.alunoToAlunoRDTO(aluno);
	}

	@Override
	public List<AlunoRDTO> findAll() {
		return this.repository.findAll().stream().map(this.alunoProcess::alunoToAlunoRDTO).toList();
	}

	@Override
	public void delete(Long id) {
		Aluno aluno = this.alunoProcess.existsById(id);
		this.repository.delete(aluno);
	}

	@Override
	public AlunoRDTO update(AlunoUDTO alunoUDTO) {
		Aluno aluno = this.alunoProcess.existsById(alunoUDTO.id());
		aluno.update(alunoUDTO);
		return this.alunoProcess.alunoToAlunoRDTO(this.repository.save(aluno));
	}

}
