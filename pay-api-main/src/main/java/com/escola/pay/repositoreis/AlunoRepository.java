package com.escola.pay.repositoreis;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.escola.pay.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Transactional(readOnly = true)
	Optional<Aluno> findByNome(String nome);

}
