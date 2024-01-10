package com.seoulawake.backend.module.cafe.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.seoulawake.backend.module.cafe.domain.Cafe;

@GraphQlRepository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
	Optional<Cafe> findByName(String name);
}
