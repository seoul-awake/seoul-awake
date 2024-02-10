package seoulawake.server.global.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class SeoulAwakeException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)

enum class ErrorCode(
  val code: String,
  val httpStatus: HttpStatus,
  val message: String,
) {
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
