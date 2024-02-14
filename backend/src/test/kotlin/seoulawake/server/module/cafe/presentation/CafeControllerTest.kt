package seoulawake.server.module.cafe.presentation

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.setExp
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import seoulawake.server.common.util.ApiTag
import seoulawake.server.common.util.RestDocument
import seoulawake.server.global.exception.ErrorCode.ALREADY_REGISTERED_CAFE
import seoulawake.server.global.support.ApiTestSupport
import seoulawake.server.module.cafe.domain.*
import seoulawake.server.module.cafe.dto.RegisterCafe

internal class CafeControllerTest(
  @Autowired private val cafeRepository: CafeRepository
) : ApiTestSupport() {

  @Nested
  inner class `카페 등록 테스트` {
    @Test
    fun `카페 등록 성공`() {
      // given
      val request = RegisterCafe.fixture()

      // when
      val result = mockMvc.perform(
        RestDocumentationRequestBuilders.post("/cafes")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(request))
      )

      // then
      result.andExpectAll(
        status().isOk,
        jsonPath("$.code").value("S001"),
        jsonPath("$.message").value("성공적으로 요청을 수행했습니다."),
      )

      // docs
      result.andDo(
        RestDocument.builder()
          .identifier("register-cafe")
          .tag(ApiTag.CAFE)
          .summary("카페 등록 API")
          .description("주어진 위치 정보와 이름으로 카페를 등록한다.")
          .result(result)
          .generateDocs()
      )
    }

    @Test
    fun `카페 등록 실패 - 이미 등록된 카페`() {
      // given
      val name = "집 앞 커피"
      val address = "집 앞"

      cafeRepository.saveAndFlush(Cafe(name, Address(address, address), Coordinates(1.0, 1.0)))

      val request = RegisterCafe.fixture(name = name, address = address)

      // when
      val result = mockMvc.perform(
        RestDocumentationRequestBuilders.post("/cafes")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(request))
      )

      // then
      result.andExpectAll(
        status().isConflict,
        jsonPath("$.code").value(ALREADY_REGISTERED_CAFE.code),
        jsonPath("$.message").value(ALREADY_REGISTERED_CAFE.message),
      )

      // docs
      result.andDo(
        RestDocument.builder()
          .identifier("register-cafe-fail-already-registered")
          .tag(ApiTag.CAFE)
          .result(result)
          .generateDocs()
      )
    }
  }

  @Test
  fun `모든 카페 가져오기 성공`() {
    // given
    val cafes = sut.giveMeBuilder<Cafe>()
      .setExp(Cafe::name, randomString())
      .setExp(Cafe::address, Address(randomString(), randomString()))
      .setExp(Cafe::coordinates, Coordinates(randomDouble(), randomDouble()))
      .setExp(Cafe::status, Status())
      .sampleList(2)

    cafeRepository.saveAll(cafes)

    // when
    val result = mockMvc.perform(
      RestDocumentationRequestBuilders.get("/cafes")
        .contentType(MediaType.APPLICATION_JSON)
    )

    // then
    result.andExpectAll(
      status().isOk,
      jsonPath("$.code").value("S001"),
      jsonPath("$.message").value("성공적으로 요청을 수행했습니다."),
      jsonPath("$.data").isArray,
      jsonPath("$.data[0].name").value(cafes[0].name),
      jsonPath("$.data[0].address").value(cafes[0].address.address),
      jsonPath("$.data[0].roadAddress").value(cafes[0].address.roadAddress),
      jsonPath("$.data[0].latitude").value(cafes[0].coordinates.latitude),
      jsonPath("$.data[0].longitude").value(cafes[0].coordinates.longitude),
      jsonPath("$.data[0].verified").value(cafes[0].status.verified),
    )

    // docs
    result.andDo(
      RestDocument.builder()
        .identifier("get-all-cafes")
        .tag(ApiTag.CAFE)
        .summary("모든 카페 가져오기 API")
        .description("현재 등록된 모든 카페 정보를 불러옵니다.")
        .result(result)
        .generateDocs()
    )
  }
}
