package com.seoulawake.backend.module.cafe.domain.repository;

import com.seoulawake.backend.module.cafe.domain.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.Optional;

@GraphQlRepository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
    Optional<Cafe> findByName(String name);
}
