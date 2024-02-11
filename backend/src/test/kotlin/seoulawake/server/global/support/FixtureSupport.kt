package seoulawake.server.global.support

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import net.jqwik.api.Arbitraries
import net.jqwik.api.Arbitrary
import kotlin.random.Random

abstract class FixtureSupport(
  protected val sut: FixtureMonkey = FixtureMonkey.builder()
    .plugin(KotlinPlugin())
    .build(),
) {
  private val randomStringArbitrary: Arbitrary<String> = sut.giveMeBuilder<String>()
    .set(Arbitraries.strings().ofMinLength(1).alpha())
    .build()

  protected fun randomString(): String = randomStringArbitrary.sample()

  protected fun randomDouble(): Double = Random.nextDouble(0.00000, 9999.99999)
}
