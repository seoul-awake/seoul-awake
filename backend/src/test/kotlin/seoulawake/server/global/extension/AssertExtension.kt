package seoulawake.server.global.extension

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.ThrowableAssert
import seoulawake.server.global.exception.ErrorCode
import seoulawake.server.global.exception.SeoulAwakeException

fun assertThatSeoulAwakeException(errorCode: ErrorCode, throwingCallable: ThrowableAssert.ThrowingCallable) {
  assertThatExceptionOfType(SeoulAwakeException::class.java)
    .isThrownBy(throwingCallable)
    .extracting("errorCode")
    .isEqualTo(errorCode)
}
