package seoulawake.server.global.exception

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import seoulawake.server.global.exception.ErrorCode.INTERNAL_ERROR

@RestControllerAdvice
class GlobalExceptionHandler {
  @ExceptionHandler(RuntimeException::class)
  fun handleUnexpectedException(ex: RuntimeException): ErrorResponse {
    return ErrorResponse.from(INTERNAL_ERROR)
  }
}
