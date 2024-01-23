package seoulawake.server.global.util

import jakarta.persistence.EntityNotFoundException

fun entityNotFound(): Nothing {
  throw EntityNotFoundException()
}
