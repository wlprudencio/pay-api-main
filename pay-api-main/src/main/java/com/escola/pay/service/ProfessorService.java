package com.escola.pay.service;

import java.util.List;

import com.escola.pay.dtos.ProfessorPDTO;
import com.escola.pay.dtos.ProfessorRDTO;
import com.escola.pay.dtos.ProfessorUDTO;

public interface ProfessorService {

	ProfessorRDTO create(ProfessorPDTO professorPDTO);

	ProfessorRDTO findById(Long id);

	List<ProfessorRDTO> findAll();

	void delete(Long id);

	ProfessorRDTO update(ProfessorUDTO professorUDTO);

}
