package seoulawake.server.global.support

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.filter.CharacterEncodingFilter

@Transactional
@AutoConfigureMockMvc
@ExtendWith(RestDocumentationExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class ApiTestSupport : FixtureSupport() {
  @Autowired
  private lateinit var mockMvc: MockMvc

  @BeforeEach
  fun setup(
    webApplicationContext: WebApplicationContext,
    restDocumentation: RestDocumentationContextProvider
  ) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
      .alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print())
      .apply<DefaultMockMvcBuilder>(MockMvcRestDocumentation.documentationConfiguration(restDocumentation))
      .addFilter<DefaultMockMvcBuilder>(CharacterEncodingFilter("UTF-8", true))
      .build()
  }
}
