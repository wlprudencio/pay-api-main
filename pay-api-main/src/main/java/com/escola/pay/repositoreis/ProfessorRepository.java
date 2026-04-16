package com.escola.pay.repositoreis;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.escola.pay.model.Aluno;
import com.escola.pay.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	@Transactional(readOnly = true)
	Optional<Professor> findByNome(String nome);

}
