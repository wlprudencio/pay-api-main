package com.escola.pay.service;

import java.util.List;

import com.escola.pay.dtos.AlunoPDTO;
import com.escola.pay.dtos.AlunoRDTO;
import com.escola.pay.dtos.AlunoUDTO;

public interface AlunoService {

	AlunoRDTO create(AlunoPDTO alunoPDTO);

	AlunoRDTO findById(Long id);

	List<AlunoRDTO> findAll();

	void delete(Long id);

	AlunoRDTO update(AlunoUDTO alunoUDTO);

}
