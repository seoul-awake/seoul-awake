package seoulawake.server.global.exception

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import seoulawake.server.global.common.ApiResult
import seoulawake.server.global.exception.ErrorCode.INTERNAL_ERROR

private val log = KotlinLogging.logger {}

@RestControllerAdvice
class GlobalExceptionHandler {
  @ExceptionHandler(RuntimeException::class)
  @ResponseStatus(INTERNAL_SERVER_ERROR)
  fun handleUnexpectedException(ex: RuntimeException): ResponseEntity<*> {
    log.error(ex) { "Unexpected Exception Occurs : ${ex.message}" }

    return ApiResult.error(INTERNAL_ERROR)
  }

  @ExceptionHandler(SeoulAwakeException::class)
  fun handleApplicationException(ex: SeoulAwakeException): ResponseEntity<*> {
    log.error(ex) { "Application Exception Occurs : ${ex.message}" }

    val errorCode = ex.errorCode

    return ApiResult.error(errorCode)
  }
}
