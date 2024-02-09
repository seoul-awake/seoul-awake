package seoulawake.server.module.cafe.domain

import jakarta.persistence.Embeddable

@Embeddable
class Status(
  var verified: Boolean = false,
  var deleted: Boolean = false
)
