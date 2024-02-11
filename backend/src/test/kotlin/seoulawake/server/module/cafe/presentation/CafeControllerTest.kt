package seoulawake.server.module.cafe.presentation

import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import seoulawake.server.common.util.ApiTag
import seoulawake.server.common.util.RestDocument
import seoulawake.server.global.support.ApiTestSupport
import seoulawake.server.module.cafe.dto.RegisterCafe

internal class CafeControllerTest : ApiTestSupport() {

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
}
