package seoulawake.server.module.cafe.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
internal class CafeRepositoryTest(
  @Autowired private val cafeRepository: CafeRepository
) {

  @Test
  fun `existsByNameOrAddress_Address 성공 - 이미 등록된 카페가 있으면 true를 리턴해야 한다`() {
    // given
    val name = "집 앞 커피"
    val address = "집 앞"

    cafeRepository.saveAndFlush(Cafe(name, Address(address, address), Coordinates(1.0, 1.0)))

    // when
    val shouldBeTrue = cafeRepository.existsByNameOrAddress_Address(name, address)

    // then
    assertThat(shouldBeTrue).isTrue()
  }

  @Test
  fun `existsByNameOrAddress_Address 성공 - 등록된 카페가 아니면 false를 리턴해야 한다`() {
    // given

    // when
    val shouldBeFalse = cafeRepository.existsByNameOrAddress_Address("근처 카페", "근처임")

    // then
    assertThat(shouldBeFalse).isFalse()
  }
}
