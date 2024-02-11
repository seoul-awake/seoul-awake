package seoulawake.server.module.cafe.domain

import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import seoulawake.server.global.exception.ErrorCode
import seoulawake.server.global.extension.assertThatSeoulAwakeException
import seoulawake.server.global.support.FixtureSupport

internal class CoordinatesTest : FixtureSupport() {

  @Test
  fun `위치 정보 생성 성공`() {
    // given

    // when, then
    assertThatNoException().isThrownBy {
      Coordinates(37.6438741, 126.6690268)
    }
  }

  @ParameterizedTest
  @MethodSource("lessAndEqualToZero")
  fun `위치 정보 생성 실패 - 0 이하 값이 입력됨`(latitude: Double, longitude: Double) {
    // given

    // when, then
    assertThatSeoulAwakeException(ErrorCode.PARAMETER_VIOLATION_ERROR) {
      Coordinates(latitude, longitude)
    }
  }

  companion object {
    @JvmStatic
    fun lessAndEqualToZero() = listOf(
      Arguments.of(0.0, 1.0),
      Arguments.of(-1.0, 1.0),
      Arguments.of(1.0, 0.0),
      Arguments.of(1.0, -1.0),
    )
  }
}
