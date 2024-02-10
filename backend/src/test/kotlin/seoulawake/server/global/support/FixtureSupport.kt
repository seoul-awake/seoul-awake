package seoulawake.server.global.support

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin

abstract class FixtureSupport(
  val sut: FixtureMonkey = FixtureMonkey.builder()
    .plugin(KotlinPlugin())
    .build()
)
