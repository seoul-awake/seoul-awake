package seoulawake.server.module.cafe.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import seoulawake.server.global.common.ApiResult
import seoulawake.server.module.cafe.application.CafeService
import seoulawake.server.module.cafe.dto.RegisterCafe

@RestController
@RequestMapping("/cafes")
class CafeController(
  private val cafeService: CafeService
) {

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  fun getAll(): ApiResult<*> {
    val response = cafeService.loadAllCafes()
    return ApiResult.ok(response)
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  fun register(@RequestBody request: RegisterCafe): ApiResult<*> {
    cafeService.register(request)
    return ApiResult.ok()
  }
}
