package seoulawake.server.global.common

import org.springframework.http.ResponseEntity
import seoulawake.server.global.exception.ErrorCode

data class ApiResult<T>(
  val code: String,
  val message: String,
  val data: T,
) {
  companion object {
    fun from(errorCode: ErrorCode): ApiResult<*> {
      return ApiResult(errorCode.code, errorCode.message, null)
    }

    fun <T> of(errorCode: ErrorCode, data: T): ApiResult<T> {
      return ApiResult(errorCode.code, errorCode.message, data)
    }

    fun error(errorCode: ErrorCode): ResponseEntity<*> {
      return ResponseEntity.status(errorCode.httpStatus).body(from(errorCode))
    }
  }
}
