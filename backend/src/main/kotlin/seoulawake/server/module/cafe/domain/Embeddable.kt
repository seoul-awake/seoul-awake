package seoulawake.server.module.cafe.domain

import jakarta.persistence.Embeddable

@Embeddable
class Address(
  val address: String,
  val roadAddress: String,
)

@Embeddable
class Coordinates(
  val latitude: Double,
  val longitude: Double,
)

@Embeddable
class Status(
  var verified: Boolean = false,
  var deleted: Boolean = false
)
