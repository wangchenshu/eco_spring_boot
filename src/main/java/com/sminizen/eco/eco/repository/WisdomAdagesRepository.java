package com.sminizen.eco.eco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sminizen.eco.eco.model.WisdomAdages;

@Repository
public interface WisdomAdagesRepository extends JpaRepository<WisdomAdages, Integer> {

	List<WisdomAdages> findAll();

	Optional<WisdomAdages> findById(int id);

	@Query(nativeQuery = true, value = "SELECT * FROM eco_wisdom_adages where length(words) < 60 ORDER BY rand() LIMIT 1")
	Optional<WisdomAdages> findByRandom();
}
