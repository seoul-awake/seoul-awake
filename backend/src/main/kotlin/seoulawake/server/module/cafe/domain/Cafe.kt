package seoulawake.server.module.cafe.domain

import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import seoulawake.server.global.common.BaseEntity
import seoulawake.server.global.exception.ErrorCode.PARAMETER_VIOLATION_ERROR
import seoulawake.server.global.exception.validate

@Entity
@AttributeOverride(name = "id", column = Column(name = "cafe_id"))
class Cafe(
  var name: String,

  @Embedded
  var address: Address,

  @Embedded
  var coordinates: Coordinates,

  @Embedded
  val status: Status = Status()
) : BaseEntity() {
  init {
    validate(this.name.isNotBlank()) { PARAMETER_VIOLATION_ERROR }
  }
}
