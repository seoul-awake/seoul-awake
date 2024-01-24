package seoulawake.server.global.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
  val httpStatus: HttpStatus,
  val message: String
) {
  INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다. 관리자에게 문의주세요."),
}
