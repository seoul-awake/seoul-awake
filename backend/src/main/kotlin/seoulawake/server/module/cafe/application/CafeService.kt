package seoulawake.server.module.cafe.application

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import seoulawake.server.global.util.entityNotFound
import seoulawake.server.module.cafe.domain.Address
import seoulawake.server.module.cafe.domain.Cafe
import seoulawake.server.module.cafe.domain.CafeRepository
import seoulawake.server.module.cafe.domain.Coordinates

@Service
@Transactional(readOnly = true)
class CafeService(
  val cafeRepository: CafeRepository,
) {

  @Transactional
  fun create(address: String): Cafe {
    val cafe = Cafe("cafe", Address("address", "roadAddress"), Coordinates(00.00, 00.00))
    return cafeRepository.save(cafe)
  }

  fun loadCafeByName(name: String): Cafe {
    return cafeRepository.findByName(name) ?: entityNotFound()
  }
}
