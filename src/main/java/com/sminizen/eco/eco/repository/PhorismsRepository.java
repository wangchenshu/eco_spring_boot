package com.sminizen.eco.eco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sminizen.eco.eco.model.Phorisms;

@Repository
public interface PhorismsRepository  extends JpaRepository<Phorisms, Integer> {

	List<Phorisms> findAll();

	Optional<Phorisms> findById(int id);

	@Query(nativeQuery = true, value = "SELECT * FROM eco_phorisms ORDER BY rand() LIMIT 1")
	Optional<Phorisms> findByRandom();
}
