package seoulawake.server.module.cafe.domain

import org.springframework.data.jpa.repository.JpaRepository

interface CafeRepository : JpaRepository<Cafe, Long> {
  fun findByName(name: String): Cafe?
}
