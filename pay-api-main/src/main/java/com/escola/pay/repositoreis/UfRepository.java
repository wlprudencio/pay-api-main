package com.escola.pay.repositoreis;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.escola.pay.model.UF;

@Repository
public interface UfRepository extends JpaRepository<UF, Long>{

	@Query("SELECT u FROM UF u WHERE u.sigla= ?1")
	Optional<UF> findBySigla(String uf);

}
