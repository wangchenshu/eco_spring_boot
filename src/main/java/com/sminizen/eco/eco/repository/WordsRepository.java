package com.sminizen.eco.eco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sminizen.eco.eco.model.Words;

@Repository
public interface WordsRepository extends JpaRepository<Words, Integer> {

	List<Words> findAll();

	Optional<Words> findById(int id);

	@Query(nativeQuery = true, value = "SELECT * FROM eco_words where length(words) < 60 ORDER BY rand() LIMIT 1")
	Optional<Words> findByRandom();
}