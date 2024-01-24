package seoulawake.server.module.cafe.presentation

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import seoulawake.server.module.cafe.application.CafeService

@RestController
@RequestMapping("/cafes")
class CafeController(
  val cafeService: CafeService
) {
  
}
