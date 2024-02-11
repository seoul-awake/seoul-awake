package seoulawake.server.module.cafe.dto

sealed interface CafeResponse

data class CafeDetails(
  val name: String,
  val address: String,
  val roadAddress: String,
  val latitude: Double,
  val longitude: Double,
  val verified: Boolean,
) : CafeResponse
