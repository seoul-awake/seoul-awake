package seoulawake.server.module.cafe.application

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import seoulawake.server.global.exception.ErrorCode.ALREADY_REGISTERED_CAFE
import seoulawake.server.global.exception.validate
import seoulawake.server.module.cafe.domain.Address
import seoulawake.server.module.cafe.domain.Cafe
import seoulawake.server.module.cafe.domain.CafeRepository
import seoulawake.server.module.cafe.domain.Coordinates
import seoulawake.server.module.cafe.dto.CafeDetails
import seoulawake.server.module.cafe.dto.RegisterCafe

@Service
@Transactional(readOnly = true)
class CafeService(
  private val cafeRepository: CafeRepository,
) {

  @Transactional
  fun register(request: RegisterCafe) {
    val (name, address, roadAddress, latitude, longitude) = request
    validateNotRegistered(name, address)
    val cafe = Cafe(name, address = Address(address, roadAddress), coordinates = Coordinates(latitude, longitude))
    cafeRepository.save(cafe)
  }

  private fun validateNotRegistered(name: String, address: String) {
    validate(!cafeRepository.existsByNameOrAddress_Address(name, address)) { ALREADY_REGISTERED_CAFE }
  }

  fun loadAllCafes(): List<CafeDetails> {
    return cafeRepository.findAll().map {
      CafeDetails(
        it.name,
        it.address.address,
        it.address.roadAddress,
        it.coordinates.latitude,
        it.coordinates.longitude,
        it.status.verified
      )
    }.toList()
  }
}
