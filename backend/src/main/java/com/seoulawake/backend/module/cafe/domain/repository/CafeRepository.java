package com.seoulawake.backend.module.cafe.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoulawake.backend.module.cafe.domain.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
	Optional<Cafe> findByName(String name);
}
