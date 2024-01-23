package seoulawake.server.global.exception

import org.springframework.http.HttpStatus

data class ErrorResponse(
  val httpStatus: HttpStatus,
  val message: String,
) {
  companion object {
    fun from(errorCode: ErrorCode): ErrorResponse {
      return ErrorResponse(errorCode.httpStatus, errorCode.message)
    }
  }
}
