package seoulawake.server.module.cafe.domain

import jakarta.persistence.Embeddable
import seoulawake.server.global.exception.ErrorCode
import seoulawake.server.global.exception.validate

@Embeddable
class Coordinates(
  val latitude: Double,
  val longitude: Double,
) {
  init {
    validate(this.latitude > 0.0) { ErrorCode.PARAMETER_VIOLATION_ERROR }
    validate(this.longitude > 0.0) { ErrorCode.PARAMETER_VIOLATION_ERROR }
  }
}
