package seoulawake.server.module.cafe.domain

import jakarta.persistence.Embeddable

@Embeddable
class Address(
  val address: String,
  val roadAddress: String,
)
