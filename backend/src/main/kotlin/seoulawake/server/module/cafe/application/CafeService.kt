package seoulawake.server.module.cafe.application

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import seoulawake.server.global.extension.entityNotFound
import seoulawake.server.module.cafe.domain.Address
import seoulawake.server.module.cafe.domain.Cafe
import seoulawake.server.module.cafe.domain.CafeRepository
import seoulawake.server.module.cafe.domain.Coordinates
import seoulawake.server.module.cafe.dto.RegisterCafe

@Service
@Transactional(readOnly = true)
class CafeService(
  private val cafeRepository: CafeRepository,
) {

  @Transactional
  fun register(request: RegisterCafe) {
    val (name, address, roadAddress, latitude, longitude) = request
    val cafe = Cafe(name, address = Address(address, roadAddress), coordinates = Coordinates(latitude, longitude))
    cafeRepository.save(cafe)
  }

  fun loadCafeByName(name: String): Cafe {
    return cafeRepository.findByName(name) ?: entityNotFound()
  }
}
