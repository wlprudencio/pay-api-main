package com.escola.pay.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.escola.pay.dtos.ProfessorPDTO;
import com.escola.pay.dtos.ProfessorRDTO;
import com.escola.pay.dtos.ProfessorUDTO;
import com.escola.pay.model.Endereco;
import com.escola.pay.model.Professor;
import com.escola.pay.repositoreis.ProfessorRepository;
import com.escola.pay.service.EnderecoService;
import com.escola.pay.service.ProfessorService;
import com.escola.pay.service.process.ProfessorProcess;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceimpl implements ProfessorService {

	private final ProfessorRepository repository;
	private final EnderecoService enderecoService;
	private final ProfessorProcess professorProcess;

	@Override
	public ProfessorRDTO create(ProfessorPDTO professorPDTO) {
		this.professorProcess.alertExistsNome(professorPDTO.nome());
		Endereco endereco = this.enderecoService.create(professorPDTO.endereco());
		Professor professor = Professor.builder().nome(professorPDTO.nome()).email(professorPDTO.email())
				.telefone(professorPDTO.telefone()).endereco(endereco).dataNascimento(professorPDTO.dataNascimento())
				.build();
		professor = this.repository.save(professor);

		return this.professorProcess.professorToProfessorRDTO(professor);
	}

	@Override
	public ProfessorRDTO findById(Long id) {
		Professor professor = this.professorProcess.existsById(id);
		return this.professorProcess.professorToProfessorRDTO(professor);
	}

	@Override
	public List<ProfessorRDTO> findAll() {
		return this.repository.findAll().stream().map(this.professorProcess::professorToProfessorRDTO).toList();
	}

	@Override
	public void delete(Long id) {
		Professor professor = this.professorProcess.existsById(id);
		this.repository.delete(professor);
	}

	@Override
	public ProfessorRDTO update(ProfessorUDTO professorUDTO) {
		Professor professor = this.professorProcess.existsById(professorUDTO.id());
		professor.update(professorUDTO);
		return this.professorProcess.professorToProfessorRDTO(this.repository.save(professor));
	}

}
