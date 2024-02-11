package seoulawake.server.module.cafe.dto

sealed interface CafeRequest

data class RegisterCafe(
  val name: String,
  val address: String,
  val roadAddress: String,
  val latitude: Double,
  val longitude: Double,
) : CafeRequest {
  companion object {
    fun fixture(
      name: String = "24시 카페",
      address: String = "집 앞",
      roadAddress: String = "집 앞",
      latitude: Double = 1.0,
      longitude: Double = 1.0,
    ): RegisterCafe {
      return RegisterCafe(name, address, roadAddress, latitude, longitude)
    }
  }
}
