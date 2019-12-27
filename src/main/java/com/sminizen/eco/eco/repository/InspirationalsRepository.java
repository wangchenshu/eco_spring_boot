package com.sminizen.eco.eco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sminizen.eco.eco.model.Inspirationals;

public interface InspirationalsRepository extends JpaRepository<Inspirationals, Integer>{

	List<Inspirationals> findAll();

	Optional<Inspirationals> findById(int id);

	@Query(nativeQuery = true, value = "SELECT * FROM eco_inspirationals where length(words) < 60 ORDER BY rand() LIMIT 1")
	Optional<Inspirationals> findByRandom();
}
