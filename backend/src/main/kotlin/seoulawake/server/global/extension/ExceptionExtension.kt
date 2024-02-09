package seoulawake.server.global.extension

import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull

fun entityNotFound(): Nothing = throw EntityNotFoundException()

fun <T, ID> CrudRepository<T, ID>.findByIdOrThrow(id: ID): T = findByIdOrNull(id) ?: entityNotFound()
