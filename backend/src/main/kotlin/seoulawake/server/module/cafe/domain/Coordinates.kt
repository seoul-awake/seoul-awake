package seoulawake.server.module.cafe.domain

import jakarta.persistence.Embeddable

@Embeddable
class Coordinates(
  val latitude: Double,
  val longitude: Double,
)
