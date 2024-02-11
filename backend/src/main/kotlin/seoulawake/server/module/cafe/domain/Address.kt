package seoulawake.server.module.cafe.domain

import jakarta.persistence.Embeddable
import seoulawake.server.global.exception.ErrorCode
import seoulawake.server.global.exception.validate

@Embeddable
class Address(
  val address: String,
  val roadAddress: String,
) {
  init {
    validate(this.address.isNotBlank()) { ErrorCode.PARAMETER_VIOLATION_ERROR }
    validate(this.roadAddress.isNotBlank()) { ErrorCode.PARAMETER_VIOLATION_ERROR }
  }
}
