package seoulawake.server.global.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class SeoulAwakeException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)

enum class ErrorCode(
  val code: String,
  val httpStatus: HttpStatus,
  val message: String,
) {
  PARAMETER_VIOLATION_ERROR("F001", BAD_REQUEST, "올바르지 않은 데이터입니다."),
  ALREADY_REGISTERED_CAFE("F002", CONFLICT, "이미 등록된 카페입니다."),

  INTERNAL_ERROR("E001", INTERNAL_SERVER_ERROR, "서버 내부 오류입니다. 관리자에게 문의주세요."),
}

@OptIn(ExperimentalContracts::class)
fun validate(value: Boolean, lazyErrorCode: () -> ErrorCode) {
  contract {
    returns() implies value
  }
  if (!value) {
    val errorCode = lazyErrorCode()
    throw SeoulAwakeException(errorCode)
  }
}
