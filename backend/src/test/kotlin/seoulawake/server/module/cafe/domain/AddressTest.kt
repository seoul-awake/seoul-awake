package seoulawake.server.module.cafe.domain

import net.jqwik.api.Arbitraries
import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import seoulawake.server.global.exception.ErrorCode
import seoulawake.server.global.extension.assertThatSeoulAwakeException
import seoulawake.server.global.support.FixtureSupport

internal class AddressTest : FixtureSupport() {

  @RepeatedTest(100)
  fun `주소 생성 성공`() {
    // given
    val randomString = sut.giveMeBuilder(String::class.java)
      .set(Arbitraries.strings().ofMinLength(1).alpha())
      .build()

    val address: String = randomString.sample()
    val roadAddress: String = randomString.sample()

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
