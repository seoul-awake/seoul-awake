package seoulawake.server.global.common

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.springframework.http.ResponseEntity
import seoulawake.server.global.exception.ErrorCode

@JsonPropertyOrder("code", "message", "data")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResult<T>(
  val code: String,
  val message: String,
  val data: T,
) {
  companion object {
    fun ok(): ApiResult<*> {
      return ok(null)
    }

    fun <T> ok(data: T): ApiResult<*> {
      return ApiResult("S001", "성공적으로 요청을 수행했습니다.", data)
    }

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
