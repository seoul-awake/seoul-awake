package seoulawake.server.module.cafe.domain

import com.navercorp.fixturemonkey.kotlin.giveMeOne
import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import seoulawake.server.global.exception.ErrorCode
import seoulawake.server.global.extension.assertThatSeoulAwakeException
import seoulawake.server.global.support.FixtureSupport

internal class AddressTest : FixtureSupport() {

  @Test
  fun `주소 생성 성공`() {
    // given
    val address: String = sut.giveMeOne()
    val roadAddress: String = sut.giveMeOne()

    // when, then
    assertThatNoException().isThrownBy {
      Address(address, roadAddress)
    }
  }

  @ParameterizedTest
  @MethodSource("emptyOrBlankAddressInputs")
  fun `주소 생성 실패 - 빈 값이 들어와서 실패`(address: String, roadAddress: String) {
    // given

    // when, then
    assertThatSeoulAwakeException(ErrorCode.PARAMETER_VIOLATION_ERROR) {
      Address(address, roadAddress)
    }
  }

  companion object {
    @JvmStatic
    fun emptyOrBlankAddressInputs() = listOf(
      Arguments.of("a", ""),
      Arguments.of("a", " "),
      Arguments.of("", "a"),
      Arguments.of(" ", "a"),
    )
  }
}
